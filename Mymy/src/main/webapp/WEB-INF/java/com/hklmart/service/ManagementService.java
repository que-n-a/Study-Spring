package com.hklmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hklmart.domain.BoardAskDTO;
import com.hklmart.domain.BoardReviewListDTO;
import com.hklmart.domain.MemberListDTO;
import com.hklmart.domain.ProductListDTO;
import com.hklmart.domain.ProductModifyDTO;
import com.hklmart.persistence.ManagementDAO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ManagementService {

	@Autowired
	ManagementDAO managmentDAO;
	
	public List<ProductListDTO> getProductList() {
		
		return managmentDAO.getProductList();
	}

	public List<BoardAskDTO> getAskBoardList() {
		
		return managmentDAO.getAskBoardList();
	}

	public List<BoardReviewListDTO> getBoardReviewList() {
		
		return managmentDAO.getBoardReviewList();
	}

	public List<MemberListDTO> getMemberList() {
		// TODO Auto-generated method stub
		return managmentDAO.getMemberList();
	}

	public ProductModifyDTO getModify(String productCode) {
		
		return managmentDAO.getModify(productCode);
	}

	public BoardAskDTO getAskAnswer(String boardAskNumber) {
	
		return managmentDAO.getAskAnswer(boardAskNumber);
	}
	
	
}
