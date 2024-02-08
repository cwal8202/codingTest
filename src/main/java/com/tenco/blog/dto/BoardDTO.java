package com.tenco.blog.dto;

import lombok.Data;

/**
  * @FileName : SaveFormDTO.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : 글쓰기 DTO입니다.
  */
@Data
public class BoardDTO {
	private Integer id;				// id
	private String content;			// 내용
	private String author;			// 작성자
	private String title;			// 제목
}
