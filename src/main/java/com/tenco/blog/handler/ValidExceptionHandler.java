package com.tenco.blog.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tenco.blog.handler.exception.ValidException;

/**
  * @FileName : ValidExceptionHandler.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : ValidException 발생시 alert창으로 에러 처리할 예정
  */
@RestControllerAdvice
public class ValidExceptionHandler {
	@ExceptionHandler(ValidException.class)
	public String basicException(ValidException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "'); ");
		sb.append("window.history.back();");
		sb.append("</script>");
		return sb.toString();
	}

}
