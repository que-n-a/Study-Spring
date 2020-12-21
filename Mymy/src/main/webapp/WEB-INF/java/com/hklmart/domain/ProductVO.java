package com.hklmart.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	private String productName;
	private String productCode;
	private String productBrand;
	private String productPrice;
	private String productType;
	private String productContent;
	private String productImgPath;
	private String productImg;
	private String productThumbnail;
	private Date productRegdate;
	private String productContentImg;
	private String productContentImgpath;
	
}
