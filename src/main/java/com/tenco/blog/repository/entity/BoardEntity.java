package com.tenco.blog.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
  * @FileName : BoardEntity.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : 게시판 엔티티입니다.
  */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity {
	private Integer id;				// id
	private String title;			// 제목
	private String content;			// 내용
	private String author;			// 작성자
}
