package com.cmz.service;

import com.cmz.entity.ScoreForm;

public interface IScoreFormService {
	public void updateScoreForm(ScoreForm scoreForm);
	public ScoreForm queryScoreFormById(int sid);
}
