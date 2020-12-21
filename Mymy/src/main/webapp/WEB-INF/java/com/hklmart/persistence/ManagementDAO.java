package com.hklmart.persistence;

import java.util.List;

import com.hklmart.domain.BoardAskDTO;
import com.hklmart.domain.BoardReviewListDTO;
import com.hklmart.domain.MemberListDTO;
import com.hklmart.domain.ProductListDTO;
import com.hklmart.domain.ProductModifyDTO;


public interface ManagementDAO {
	
	public List<ProductListDTO> getProductList();

	public List<BoardAskDTO> getAskBoardList();

	public List<BoardReviewListDTO> getBoardReviewList();

	public List<MemberListDTO> getMemberList();

	public ProductModifyDTO getModify(String productCode);

	public BoardAskDTO getAskAnswer(String boardAskNumber);
	
}
