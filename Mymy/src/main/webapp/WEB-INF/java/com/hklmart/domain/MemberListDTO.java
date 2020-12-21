package com.hklmart.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class MemberListDTO {

	private String memberId;
	private String memberName;
	private String memberEmail;
	private String memberTel;
	private String memberRegdate;
	@Setter(AccessLevel.PROTECTED)
	private String authoritiesMember;
	@Setter(AccessLevel.PROTECTED)
	private String authoritiesManager;
	@Setter(AccessLevel.PROTECTED)
	private String authoritiesAdmin;

	private String memberAuthority;


	protected void setAuthoritiesMember(String authoritiesMember) {

		if (authoritiesMember.equals("ROLE_MEMBER")) {
			memberAuthority = "회원";

		}

	}
	protected void setAuthoritiesManager(String authoritiesManager) {
		if (authoritiesManager.equals("ROLE_MANAGER")) {
			memberAuthority = "매니저";
		}
	}

	protected void setAuthoritiesAdmin(String authoritiesAdmin) {
		if (authoritiesAdmin.equals("ROLE_ADMIN")) {
			memberAuthority = "관리자";
		} 
	}

}
