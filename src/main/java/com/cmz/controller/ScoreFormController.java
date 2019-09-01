package com.cmz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmz.entity.ScoreForm;
import com.cmz.serviceImpl.ScoreFormService;
import com.cmz.util.TipUtil;
/*
 * 成绩单相关controller
 */
@Controller
@RequestMapping("scoreForm")
public class ScoreFormController {
	@Autowired
	ScoreFormService scoreFormService ;
	/*
	 * 跳转到更新成绩单界面
	 */
	@RequestMapping("toUpdateScoreForm")
	public ModelAndView toUpdateScoreForm(@RequestParam("sid")int sid) {
		ModelAndView mv = new ModelAndView("updateScoreForm");
		ScoreForm curScoreForm = scoreFormService.queryScoreFormById(sid);
		mv.addObject("scoreForm", curScoreForm);
		return mv;
	}
	/*
	 * 更新成绩单
	 */
	@RequestMapping("updateScoreForm")
	public ModelAndView updateScoreForm(ScoreForm scoreForm) {
		scoreFormService.updateScoreForm(scoreForm);
		return TipUtil.TipFactory("已成功更新成绩!");
	}
}
