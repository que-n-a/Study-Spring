package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String bContent;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
