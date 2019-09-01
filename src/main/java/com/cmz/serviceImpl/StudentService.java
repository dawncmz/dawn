package com.cmz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.entity.ScoreForm;
import com.cmz.entity.Student;
import com.cmz.mapper.ScoreFormMapper;
import com.cmz.mapper.StudentMapper;
import com.cmz.service.IStudentService;
import java.util.*;

@Service("studentService")
public class StudentService implements IStudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ScoreFormMapper scoreFormMapper;
	
	@Override
	public boolean  addStudent(Student student) {
		scoreFormMapper.addScoreForm(new ScoreForm(student.getSid()));
		studentMapper.addStudent(student);
		return true;
	}
	@Override
	public Student queryStudentById(int id) {
		return studentMapper.queryStudentById(id);
	}
	
	@Override
	public void deleteStudentById(int sid) {
		studentMapper.deleteStudentById(sid);
	}
	@Override
	public void updateStudent(Student student) {
		studentMapper.updateStudent(student);
	}
	@Override
	public List<Student> queryStudentByPage(int curPage,int pageSize){
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		map.put("curPage",(curPage-1)*pageSize);
		map.put("pageSize", pageSize);
		return studentMapper.queryStudentByPage(map);
	}
	
	@Override
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	@Override
	public int queryStudentCount() {
		List<Student> all = studentMapper.queryAllStudent();
		return all.size();
	}
	@Override
	public boolean isExist(int sid) {
		return studentMapper.queryStudentById(sid)==null?false:true;
	}
	@Override
	public boolean isHavePicture(int sid) {
		return studentMapper.queryStudentById(sid).isHavePicture();
	}
	@Override
	public void readyHavePicture(int sid) {
		Student cur = studentMapper.queryStudentById(sid);
		cur.setHavePicture(true);
		studentMapper.updateStudent(cur);
	}
	@Override
	public List<Student> queryAllStudent() {
		return studentMapper.queryAllStudent();
	}
	@Override
	public Student queryStudentWithScoreForm(int sid) {
		return studentMapper.queryStudentWithScoreFormById(sid);
	}
	
	
	
	
}
