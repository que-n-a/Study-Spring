package com.hklmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.hklmart.domain.MemberVO;
import com.hklmart.domain.UserDetailsVO;
import com.hklmart.persistence.MemberDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberDAO mapper;

	@Override
	public UserDetails loadUserByUsername(String memberId) {

		UserDetailsVO userDetails = new UserDetailsVO();
		MemberVO member = mapper.getMemberInfo(memberId);

		if (member == null) {
			return null;

		} else {
			userDetails.setUsername(member.getMemberId());
			userDetails.setPassword(member.getMemberPw());
			userDetails.setMemberName(member.getMemberName());
			userDetails.setMemberEmail(member.getMemberEmail());
			userDetails.setMemberTel(member.getMemberTel());
			userDetails.setAuthorities(member.getAuthoritiesMember(), member.getAuthoritiesManager(), member.getAuthoritiesAdmin());
		}

		return userDetails;
	}
}