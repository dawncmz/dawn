package com.cmz.service;

import java.util.List;

import com.cmz.entity.Student;
import com.cmz.mapper.StudentMapper;

public interface IStudentService {
	public boolean addStudent(Student student);
	public Student queryStudentById(int sid);
	public int queryStudentCount() ;
	public List<Student> queryAllStudent();
	public List<Student> queryStudentByPage(int curPage,int pageSize);
	public void setStudentMapper(StudentMapper studentMapper);
	public boolean isExist(int sid);
	public boolean isHavePicture(int sid);
	public void readyHavePicture(int sid);
	public void updateStudent(Student student);
	public void deleteStudentById(int sid);
	public Student queryStudentWithScoreForm(int sid);
}
