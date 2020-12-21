package com.hklmart.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hklmart.domain.BoardAskVO;
import com.hklmart.domain.MemberVO;
import com.hklmart.service.BoardService;
import com.hklmart.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/login-page")
	public String tryLogin(Authentication authentication) {
		if (authentication == null)
			return "login-page";
		else
			return "redirect:/";
	}

	@PostMapping("/signup")
	public String doSignUp(MemberVO memberVO) {
		memberService.registMember(memberVO);
		return "redirect:/";
	}

	@PostMapping("/login-fail")
	@ResponseBody
	public Map<String, Object> failLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> loginObj = new HashMap<>();
		loginObj.put("loginStatus", request.getAttribute("loginStatus"));
		loginObj.put("loginFailMsg", request.getAttribute("loginFailMsg"));
		return loginObj;
	}

	@PostMapping("/login-success")
	@ResponseBody
	public Map<String, Object> successLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> loginObj = new HashMap<>();
		loginObj.put("loginStatus", request.getAttribute("loginStatus"));
		return loginObj;
	}

	@GetMapping("/my-page")
	public String goMyPage() {
		return "my-page";
	}

	@PostMapping("/update")
	public String passwordUpdate(Principal principal, @RequestParam("memberPw") String memberPw) {
		memberService.updatePassword(principal.getName(), memberPw);
		return "my-page";
	}

	@GetMapping("/my-page-ask-board")
	public String goMyAskBoard() {
		return "ask-board";
	}

}
