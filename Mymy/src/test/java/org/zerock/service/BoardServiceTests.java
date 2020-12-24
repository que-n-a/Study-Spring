package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired })
	private BoardService service;
	
	@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스의 제목");
		board.setBContent("서비스의 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호: " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(1L));
	}
	
	@Test
	public void testDelete() {
		
		//게시물 번호의 존재 여부를 확인하고 테스트할 것.
		log.info("REMOVE REWSULT: " + service.remove(2L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board  = service.get(1L); //특정게시물 조회.
		
		if (board == null) { //특정 게시물이 없다면, 그냥 리턴.
			
			return;
		}
		
		board.setTitle("제목을 수정합니다."); //특정 게시물이 있다면, 타이틀 수정.
		log.info("MODIFY RESULT: " + service.modify(board));
	}
}
