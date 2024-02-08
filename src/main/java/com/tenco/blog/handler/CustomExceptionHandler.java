package com.tenco.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.tenco.blog.handler.exception.CustomException;

/**
  * @FileName : CustomExceptionHandler.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : customException 발생시 에러창으로 에러 처리할 예정
  */
@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ModelAndView handlerRuntionException(CustomException e) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("statusCode", HttpStatus.NOT_FOUND.value());
		modelAndView.addObject("message", e.getMessage());
		return modelAndView; //페이지 반환 + 데이터 내려 줌 
	}
}
