package com.cmz.util;

import org.springframework.web.servlet.ModelAndView;
/*
 * 返回带有提示信息的界面
 */
public class TipUtil {
	public static ModelAndView TipFactory(String tip) {
		ModelAndView mv = new ModelAndView("tip");
		mv.addObject("tip",tip);
		return mv;
	}
}
