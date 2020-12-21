package com.hklmart.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsVO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String memberName;
	private String memberEmail;
	private String memberTel;
	private List<GrantedAuthority> authorities;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(String member, String manager, String admin) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (member != null)
			authorities.add(new SimpleGrantedAuthority(member));
		if (manager != null)
			authorities.add(new SimpleGrantedAuthority(manager));
		if (admin != null)
			authorities.add(new SimpleGrantedAuthority(admin));
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}