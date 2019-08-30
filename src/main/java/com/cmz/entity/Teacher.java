package com.cmz.entity;

import java.util.List;

public class Teacher {
	
	private int tid;
	private int tage;
	private String tname;
	private String object;
	private List<Student> students ;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Teacher(int tid,int tage,String tname,String object) {
		this.tid=tid;
		this.tage=tage;
		this.tname=tname;
		this.object = object;
	}
	public Teacher() {
		
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tage=" + tage + ", tname=" + tname + ", object=" + object + "]";
	}
	public String toStringWithStudents() {
		StringBuilder sb = new StringBuilder();
		for(Student cur:this.getStudents()) {
			sb.append(String.valueOf(cur.getSid())+":");
			sb.append(cur.getSname()+";");
		}
		return toString()+sb.toString();
	}
}
