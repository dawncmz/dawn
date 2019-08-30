package com.cmz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.entity.ScoreForm;
import com.cmz.mapper.ScoreFormMapper;
import com.cmz.service.IScoreFormService;
@Service("scoreFormService")
public class ScoreFormService implements IScoreFormService{
	@Autowired
	ScoreFormMapper scoreFormMapper ;
	
	@Override
	public void updateScoreForm(ScoreForm scoreForm) {
		scoreFormMapper.updateScoreForm(scoreForm);
	}

	@Override
	public ScoreForm queryScoreFormById(int sid) {
		return scoreFormMapper.queryScoreFormById(sid);
	}
	
}
