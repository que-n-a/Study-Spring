package com.hklmart.persistence;


import org.apache.ibatis.annotations.Insert;

import com.hklmart.domain.MemberVO;

public interface MemberDAO {
	
	public void registMember(MemberVO memberVO);
	
	public void registAuthorities(MemberVO memberVO);
	
	public MemberVO getMemberInfo(String memberId);
	
	@Insert("UPDATE MEMBER SET MEMBER_PW = #{param2} WHERE MEMBER_ID = #{param1}")
	public void updatePassword(String memberId, String memberPw);
	
	public int idDuplicatiedInspection(String userId);

	
	
}
