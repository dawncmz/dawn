package com.cmz.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 * �쳣����  ע�����ʱ��Ҫץ�쳣
 */
//@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({Exception.class})
	public String DefaultExcptionHandler(Exception e) {
		return "test/error";
	}
}
