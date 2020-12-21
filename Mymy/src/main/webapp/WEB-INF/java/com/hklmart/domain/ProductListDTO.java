package com.hklmart.domain;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ProductListDTO {

	private String productName;
	private String productCode;
	private String productBrand;
	private String productPrice;
	private String productContent;
	private String productRegdate;
	@Setter(AccessLevel.PROTECTED)
	private String productType;

	protected void setProductType(String productType) {

	
		if (Integer.parseInt(productType) == 11) {
			// 운동화
			productType = "스니커즈";
		} else if (Integer.parseInt(productType) == 12) {
			productType = "캔버스화";
		} else if (Integer.parseInt(productType) == 13) {
			productType = "슬립온";
		} else if (Integer.parseInt(productType) == 31) {
			// 스포츠
			productType = "런닝화";
		}else if(Integer.parseInt(productType)==32) {
			productType = "축구화";
		}else if(Integer.parseInt(productType)==33) {
			productType = "등산화";
		}else if(Integer.parseInt(productType)==51) {
			// 구두
			productType = "로퍼";
		}else if(Integer.parseInt(productType)==52) {
			productType = "레이스업";
		}else if(Integer.parseInt(productType)==53) {
			productType = "힐/펌프스";
		}else if(Integer.parseInt(productType)==54) {
			productType = "플랫슈즈";
		}else if(Integer.parseInt(productType)==71) {
	// 부츠
			productType = "챌시부츠";
		}else if(Integer.parseInt(productType)==72) {
			productType = "워크부츠";
		}else if(Integer.parseInt(productType)==73) {
			productType = "퍼부츠";
		}
		
		this.productType = productType;

	}
}
