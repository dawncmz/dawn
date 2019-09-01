package com.cmz.service;

import com.cmz.entity.ScoreForm;

public interface IScoreFormService {
	public void updateScoreForm(ScoreForm scoreForm); //更新成绩单
	public ScoreForm queryScoreFormById(int sid);	//查询成绩单
}
