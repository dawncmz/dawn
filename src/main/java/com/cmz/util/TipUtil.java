package com.cmz.util;

import org.springframework.web.servlet.ModelAndView;
/*
 * ���ش�����ʾ��Ϣ�Ľ���
 */
public class TipUtil {
	public static ModelAndView TipFactory(String tip) {
		ModelAndView mv = new ModelAndView("tip");
		mv.addObject("tip",tip);
		return mv;
	}
}
