package com.tenco.blog.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
  * @FileName : CustomException.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : runtimeException시 상태 코드값을 같이 던지기 위한 exception입니다.
  */
@Getter
public class ValidException extends RuntimeException {
	// 상태 코드
	private HttpStatus httpStatus;

	public ValidException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
}
