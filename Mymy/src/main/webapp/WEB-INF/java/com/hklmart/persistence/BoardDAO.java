package com.hklmart.persistence;

import com.hklmart.domain.BoardAskVO;
import com.hklmart.domain.BoardReviewVO;

public interface BoardDAO {
	
	public void insertAskBoard(BoardAskVO boardAskVO);

	public void insertBoardReview(BoardReviewVO boardReviewVO);

	public void updateAskAnswer(BoardAskVO boardAskVO);
	
}
