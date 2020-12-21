package com.hklmart.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		request.setAttribute("loginStatus", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/login-success");
		dispatcher.forward(request, response);

	}
}
