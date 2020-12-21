package com.hklmart.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class BoardAskDTO {
	
	private String boardAskNumber;
	private String boardAskMemberId;
	private String boardAskDate;
	
	@Setter(AccessLevel.PROTECTED)
	private String boardAskType;
	
	private String boardAskTitle;
	private String boardAskContent;
	private String boardAskProductCode;
	private String boardAskOrderNumber;
	private String boardAskState;
	private String boardAskAnswer;
	
	
	protected void setboardAskType(String boardAskType) {
		
		if (Integer.parseInt(boardAskType)==1) {
			boardAskType = "환불";
		}else if (Integer.parseInt(boardAskType)==2) {
			boardAskType = "교환 및 A/S";
		}else if (Integer.parseInt(boardAskType)==3) {
			boardAskType = "재입고 문의";
		}else if (Integer.parseInt(boardAskType)==4) {
			boardAskType = "주문 및 결제";
		}else if (Integer.parseInt(boardAskType)==5) {
			boardAskType = "배송 문의";
		}else if (Integer.parseInt(boardAskType)==6) {
			boardAskType = "기타 문의 사항";
		}
		
		this.boardAskType = boardAskType;
	}
	
	
}
