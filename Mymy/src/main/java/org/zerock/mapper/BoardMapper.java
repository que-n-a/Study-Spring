package org.zerock.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select; ==
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper { //BoardMapper의 파라미터를 선언. 이 인터페이스를 DAO라고 생각하면 되겠다.
	
	

	
//	  @Select("select * from tbl_board where bno > 0 ") == xml 파일에 적어주었으므로, 필요없음.
	 	
	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board); //insert만 처리되고 pk값을 알 필요가 없는 경우.
	
	public void insertSelectKey(BoardVO board); //insert처리 후 생성된 pk값 알아야하는 경우.

	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}