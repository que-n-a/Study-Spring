package com.hklmart.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberTel;
	private String authoritiesMember;
	private String authoritiesManager;
	private String authoritiesAdmin;
}
