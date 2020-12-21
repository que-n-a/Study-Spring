package com.hklmart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
public class ExceptionController {

	@RequestMapping("/exception")
	@ExceptionHandler(Exception.class)
	public String handlingException(HttpServletRequest request, HttpServletResponse response, Exception ex, Model model) {
		String message = "";
		if (response.getStatus() == 200)
			message = "관리자에게 문의바랍니다";
		else if (response.getStatus() == 400)
			message = "잘못된 요청";
		else if (response.getStatus() == 403)
			message = "권한이 없습니다";
		else if (response.getStatus() == 404)
			message = "페이지를 찾을 수 없음";
		else if (response.getStatus() == 405)
			message = "허용되지 않은 동작";
		else if (response.getStatus() == 415)
			message = "잘못된 요청";
		else if (response.getStatus() == 500)
			message = "관리자에게 문의바랍니다";
		else if (response.getStatus() == 505)
			message = "HTTP Version Not Supported";

		model.addAttribute("error", response.getStatus());
		model.addAttribute("message", message);
		return "exception";
	}

}
