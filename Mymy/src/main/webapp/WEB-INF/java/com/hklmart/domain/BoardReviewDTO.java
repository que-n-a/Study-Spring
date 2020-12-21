package com.hklmart.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardReviewDTO {

	private String boardReviewNumber;
	private String boardReviewMemberId;
	private String boardReviewProductCode;
	private String boardReviewScore;
	private String boardReviewContent;
	private String boardReviewDate;
	private String boardReviewImg;
	private String boardReviewImgpath;
	private String boardReviewThumbnail;
	private MultipartFile UploadImg;
	
	
	
}
