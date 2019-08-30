package com.cmz.entity;

public class Student {
	private int sid;
	private String sname;
	private String saddress;
	private int sage;
	private int sfid;
	boolean isHavePicture;
	ScoreForm scoreForm ;
	public ScoreForm getScoreForm() {
		return scoreForm;
	}
	public void setScoreForm(ScoreForm scoreForm) {
		this.scoreForm = scoreForm;
	}
	public boolean isHavePicture() {
		return isHavePicture;
	}
	public void setHavePicture(boolean isHavePicture) {
		this.isHavePicture = isHavePicture;
	}
	public Student() {
		
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	
	public int getSfid() {
		return sfid;
	}
	public void setSfid(int sfid) {
		this.sfid = sfid;
	}
	public Student(int id,int age,String name,String address) {
		this.sid=id;
		this.sage=age;
		this.sname=name;
		this.saddress=address;
		this.sfid=sid;
		this.isHavePicture=false;
		this.scoreForm=null;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage
				+ ", isHavePicture=" + isHavePicture + "]";
	}
	public String toStringWithScore() {
		return toString()+scoreForm.toString();
	}
	

	
}