package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.zerock.domain.Criteria;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));

		}
	
		@Test
		public void testInsert() {
			
			BoardVO board = new BoardVO();
			board.setTitle("새로 작성하는 글");
			board.setBContent("새로 작성하는 내용"); // set 바로 뒷 철자만 대문자. 나머지는 소문자로 맞춰주어야 함.
			board.setWriter("newbie");
			
			mapper.insert(board);
			
			log.info(board);
	}
		
		@Test
		public void testInsertSelectKey () {
			
			BoardVO board = new BoardVO();
			board.setTitle("새로 작성하는 글 select key");
			board.setBContent("새로 작성하는 내용 select key");
			board.setWriter("newbie");
			
			mapper.insertSelectKey(board);

			log.info(board);
		}
		
		@Test
		public void testRead() {
			
			//존재하는 게시물 번호로 테스트
			BoardVO board = mapper.read(5L);
		}
		
		@Test
		public void testDelete() {
			
			log.info("DELETE COUNT: " + mapper.delete(3L));
		}
		
		@Test
		public void testUpdate() {
			
			BoardVO board = new BoardVO();
			//실행 전 존재하는 번호인지 확인.
			board.setBno(5L);
			board.setTitle("수정된 제목");
			board.setBContent("수정된 내용");
			board.setWriter("user00");
			
			int count = mapper.update(board);
			log.info("UPDATE COUNT: " + count);
		}

		@Test
	public void testPaging() {

		Criteria cri = new Criteria();
		//2개씩 4페이지
			cri.setPageNum(4);
			cri.setAmount(2);

		List<BoardVO> list = mapper.getListWithPaging(cri);

		list.forEach(board -> log.info(board.getBno()));

		}

}
