package com.cmz.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import com.cmz.util.TipUtil;
/*
 * 异常处理  注意测试时不要抓异常
 */
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({MaxUploadSizeExceededException.class})
	public ModelAndView SizeHandler(MaxUploadSizeExceededException e) {
		return TipUtil.TipFactory("照片超出规定大小!");
	}
	@ExceptionHandler({Exception.class})
	public String DefaultExcptionHandler(Exception e) {
		return "test/error";
	}
}
