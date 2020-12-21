package com.hklmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hklmart.domain.UserDetailsVO;

@Service
public class LoginAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsServcie;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String inputId = authentication.getName();
		String inputPw = (String) authentication.getCredentials();

		UserDetailsVO userDetails = (UserDetailsVO) userDetailsServcie.loadUserByUsername(inputId);
		
		if (userDetails == null) 
			throw new AuthenticationServiceException(inputId);
		
		else if (!inputId.equals(userDetails.getName()) || !passwordEncoder.matches(inputPw, userDetails.getPassword()))
			throw new BadCredentialsException(inputId);
		
		else if (!userDetails.isAccountNonLocked())
			throw new LockedException(inputId);

		else if (!userDetails.isEnabled())
			throw new DisabledException(inputId);

		else if (!userDetails.isAccountNonExpired())
			throw new AccountExpiredException(inputId);

		else if (!userDetails.isCredentialsNonExpired())
			throw new CredentialsExpiredException(inputId);

		userDetails.setPassword(null);

		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
