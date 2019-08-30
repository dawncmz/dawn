package com.cmz.mapper;

import java.util.List;

import com.cmz.entity.ScoreForm;
import com.cmz.entity.Teacher;

public interface ScoreFormMapper {
	
	public ScoreForm queryScoreFormById (int paramter);
//	 <select id="queryScoreFormById" resultType="com.cmz.entity.ScoreForm" parameterType="int">
//	 	select * from ScoreForm where sid = #{id}
//	 </select>
	public List<ScoreForm>queryAllScoreForm();
	
	public void addScoreForm(ScoreForm paramter);
	public void deleteScoreFormById(int para);
	public void updateScoreForm(ScoreForm para);
	public List<ScoreForm>queryAllScoreFormOrderBy(String param);

}
