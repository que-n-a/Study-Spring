package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		
		log.info("basic............");
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get................");
	}
	
	@GetMapping("basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.....................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name: " + name);
		log.info("age :" + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex01List") //호출 예시: 프로젝트 경로/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("ex02Array")
	public String ez02Array(@RequestParam("ids") String[] ids) {
		
		log.info("array ids: " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("ex02Bean") //프로젝트 경로/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb       [0]를 대체
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/ex03") //ex) http://localhost:8090/sample/ex03?title=test&dueDate=2018-01-01
	public String ex03(TodoDTO todo) {
		
		log.info("todo: " + todo);
		
		return "ex03";
	}
	
	/*
	 * @GetMapping("/ex04") public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
	 * 
	 * log.info("dto: " + dto); log.info("page: " + page);
	 * 
	 * return "/sample/ex04"; }
	 */
	
	//응용해보쟈
	
	@GetMapping("/ex04")
	public void ex041(@ModelAttribute("prac") SampleDTO dto, String name) {
		
		log.info("dto: " + dto);
		log.info("name: " + name);

	}
		
	/*
	 * //RedirectAttributes model타입과 더불어 스프링 mvc의 자동전달 타입.
	 * rttr.addFlashAttribute("age", 10); rttr.addFlashAttribute("age", 10);
	 * 
	 * return "redirect:/";
	 */
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		
		log.info("/ex06.........");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
}