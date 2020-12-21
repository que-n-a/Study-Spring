package com.hklmart.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RegistProductVO {
	private String productName;
	private String productBrand;
	private String productCode;
	private String productPrice;
	private String productType;
	private String productContent;
	private MultipartFile uploadImg;
	private MultipartFile contentImg;
	private String stock240;
	private String stock245;
	private String stock250;
	private String stock255;
	private String stock260;
	private String stock265;
	private String stock270;
	private String stock275;
	private String stock280;
	private String stock285;
	private String stock290;
	private String stock295;
}
