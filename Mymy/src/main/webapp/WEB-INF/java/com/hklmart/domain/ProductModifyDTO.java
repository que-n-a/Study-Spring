package com.hklmart.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ProductModifyDTO {
	
	private String productName;
	private String productCode;
	private String productBrand;
	private String productPrice;
	private String productType;
	private String productContent;
	private String productImgPath;
	private String productImg;
	private String productThumbnail;
	private String productRegdate;
	private String productContentImg;
	private String productContentImgpath;
	private MultipartFile uploadImg;
	private MultipartFile contentImg;
	private int stock240;
	private int stock245;
	private int stock250;
	private int stock255;
	private int stock260;
	private int stock265;
	private int stock270;
	private int stock275;
	private int stock280;
	private int stock285;
	private int stock290;
	private int stock295;
	

	
}
