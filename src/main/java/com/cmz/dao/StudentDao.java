package com.cmz.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cmz.entity.Student;
import com.cmz.mapper.StudentMapper;

//@Repository("studentDao")
//@Qualifier("sqlSessionFactory")
public class StudentDao extends SqlSessionDaoSupport{
//	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//  经典错误  缺少factory不是需要你自己定义一个factory 是父类中的
	
	public void addStudent(Student student) {
		SqlSession session = super.getSqlSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		
	}
	public Student queryStudentById(int id) {
		SqlSession session = super.getSqlSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		return studentMapper.queryStudentById(id);
	}
	
}
