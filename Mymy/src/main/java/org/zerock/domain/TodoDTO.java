package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd") //자동 날짜타입 변환 바인딩 함수.
	private Date dueDate;
}
