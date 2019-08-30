package com.cmz.entity;

public class ScoreForm {
	int sid;
	int math;
	int english;
	int chinese;
	int science;
	public ScoreForm() {
	}
	public ScoreForm(int sid) {
		this.sid=sid;
		this.chinese=0;
		this.english=0;
		this.math=0;
		this.science=0;
	}
	public ScoreForm(int sid, int math, int english, int chinese, int science) {
		this.sid = sid;
		this.math = math;
		this.english = english;
		this.chinese = chinese;
		this.science = science;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	@Override
	public String toString() {
		return "ScoreForm [sid=" + sid + ", math=" + math + ", english=" + english + ", chinese=" + chinese
				+ ", science=" + science + "]";
	}
	
}
