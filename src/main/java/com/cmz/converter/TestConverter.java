package com.cmz.converter;

import org.springframework.core.convert.converter.Converter;

import com.cmz.entity.Student;

public class TestConverter implements Converter<String,Student>{

	@SuppressWarnings("null")
	public Student convert(String source) {
		Student student = new Student() ;
		String[] array = source.split("-");
		student.setSid(Integer.parseInt(array[0]));
		student.setSage(Integer.parseInt(array[1]));
		student.setSname(array[2]);
		student.setSaddress(array[3]);
		return student;
	}
	
}
