package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/home/*")
@Log4j
public class MyHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value ="/home", method = {RequestMethod.GET, RequestMethod.POST})
	public String getHome() {
		
		log.info("홈 페이지로 이동합니다.");
		
		return "index";
		
	}
	
	@GetMapping("/aboutMe")
	public String aboutMe() {
		
		log.info("자기소개 페이지로 이동합니다.");
		
		return "aboutme";
		
	}
	
	@GetMapping("/photo")
	public String phote() {
		
		log.info("자기소개 페이지로 이동합니다.");
		
		return "photo";
		
	}
	
	@RequestMapping(value= "/aboutme/today", method = RequestMethod.GET)
	public String today(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
