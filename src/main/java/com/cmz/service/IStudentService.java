package com.cmz.service;

import java.util.List;

import com.cmz.entity.Student;
import com.cmz.mapper.StudentMapper;

public interface IStudentService {
	public boolean addStudent(Student student);
	public Student queryStudentById(int sid);
	public int queryStudentCount() ;	//计算学生总数
	public List<Student> queryAllStudent();
	public List<Student> queryStudentByPage(int curPage,int pageSize);
	public void setStudentMapper(StudentMapper studentMapper);
	public boolean isExist(int sid);
	public boolean isHavePicture(int sid);  //将该学生已上传照片
	public void readyHavePicture(int sid);
	public void updateStudent(Student student);
	public void deleteStudentById(int sid);
	public Student queryStudentWithScoreForm(int sid); //外键查询 返回带有成绩单的学生 (其实应该用延迟加载/懒加载实现)
}
