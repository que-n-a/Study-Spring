package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller // 스프링의 bean으로 인식할 수 있게 함.
@Log4j
@RequestMapping("/board/*") // 로 들어오는 처리를 이 콘트롤러에서 하도록 지정.
@AllArgsConstructor
/*
 * @AllArgsConstructor 이 애노테이션은 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해줍니다. 만약
 * 필드중에서 @NonNull 애노테이션이 마크되어 있다면 생성자 내에서 null-check 로직을 자동적으로 생성해줍니다.
 */
public class BoardController {

	private BoardService service;

/*	@GetMapping("/list")
	public void list(Model model) {// 게시물 목록을 전달해야 하므로 Model을 파라미터로 지정.

		log.info("list");

		model.addAttribute("list", service.getList()); // BoardServiceImpl객체의 getList() 결과를 담아 전달.
	}*/

	@GetMapping("/list")
	public void list(Criteria cri , Model model) {// 페이징 객체와 게시물 목록을 전달해야 하므로 Model을 파라미터로 지정.

		log.info("list" + cri);

		model.addAttribute("list", service.getList(cri)); // BoardServiceImpl객체의 getList() 결과를 담아 전달.
		model.addAttribute("pageMaker", new PageDTO(cri, 123)); //전체 데이터 수의 처리가 이루어지지 않았으므로, 임의의 수 123으로 지정.
	}

	@GetMapping("/register") //게시물 등록 작업-> post지만 화면에서 입력 받기위해 get으로 입력페이지를 볼 수 있도록 콘트롤러에 메서드 추가.
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { // 등록 작업 후 다시 목록 화면으로 이동하기 위함.

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list"; // response.sendRedirect()를 MVC가 대신 처리.
	}

	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {

		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {

		log.info("modify: " + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:board/list";
	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") //@ModelAttribute은 Model에 데이터를 지정한 이름으로 담아줌.
					Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}