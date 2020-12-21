package com.hklmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hklmart.domain.MemberVO;
import com.hklmart.persistence.MemberDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MemberDAO memberDAO;

    public void registMember(MemberVO memberVO) {
        memberVO.setAuthoritiesMember("ROLE_MEMBER");
        memberVO.setAuthoritiesManager(null);
        memberVO.setAuthoritiesAdmin(null);
        memberVO.setMemberPw(passwordEncoder.encode(memberVO.getMemberPw()));
        memberDAO.registMember(memberVO);
        memberDAO.registAuthorities(memberVO);
    }

    public MemberVO getMemberInfo(String memberId) {
        MemberVO memberVO = memberDAO.getMemberInfo(memberId);
        return memberVO;
    }

    public void updatePassword(String memberId, String memberPw) {
        memberDAO.updatePassword(memberId, passwordEncoder.encode(memberPw));
    }


    public int idCheckTest(String userId) {
        return memberDAO.idDuplicatiedInspection(userId);
    }




}
