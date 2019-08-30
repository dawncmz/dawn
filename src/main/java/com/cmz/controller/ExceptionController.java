package com.cmz.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 * 异常处理  注意测试时不要抓异常
 */
//@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({Exception.class})
	public String DefaultExcptionHandler(Exception e) {
		return "test/error";
	}
}
