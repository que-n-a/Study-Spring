package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	//spring 4.3 이상에서 자동처리
	private BoardMapper mapper;
	
	
	  @Override public void register(BoardVO board) { 
		  
		  log.info("register....." + board);
	  
		  mapper.insertSelectKey(board);
	  }
		
	  @Override public BoardVO get(Long bno) { }
		
	  @Override public boolean modify(BoardVO board) { }
		
	  @Override public boolean remove(Long bno) { }
		
	  @Override public List<BoardVO> getList() { }
	  
}
