package com.cmz.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.cmz.entity.DateTest;
import com.cmz.entity.Student;
import com.cmz.serviceImpl.StudentService;
/*
 * mvc���Կ�����
 */
@Controller
@RequestMapping("Test")
public class TestController {
	
	StudentService studentService ;
	/*
	 * mvc��������
	 */
	@RequestMapping("mvctest")
	public String welcome(){
		return "test/success";
	}
	/*
	 * requestParam ע�����
	 */
	@RequestMapping("addStudent")
	public String addStudent(@RequestParam("sname") String sname,@RequestParam("sid") int sid,
			@RequestParam("sage") int sage,@RequestParam("saddress") String saddress) {
		Student student = new Student(sid,sage,sname,saddress);
		System.out.println(student);
		return "test/addStudent";
	}
	/*
	 * �ֶ��Զ�װ��������
	 * �������� �ֶ�����ͬ������
	 */
	@RequestMapping("addStudent2")
	public String addStudent2(Student student) {
		System.out.println(student.toString());
		return "test/addStudent";
	}
	/*
	 * modelAndView����
	 */
	@RequestMapping("queryStudentById")
	public ModelAndView queryStudentById() {
		ModelAndView mv= new ModelAndView("test/success");//���Զ�����ǰ׺�ͺ�׺
		Student student = new Student(201601,20,"cmz","china");
		mv.addObject("student", student);
		return mv;
	}
	/*
	 * converter����
	 * �ɼ���spring�Լ�ȥѰ�ҿ��õ�ת������������ʾָ��
	 */
	@RequestMapping("testConverter")
	public ModelAndView testConverter(@RequestParam("studentInfo") Student student) {
		ModelAndView mv= new ModelAndView("test/success");//���Զ�����ǰ׺�ͺ�׺
		mv.addObject("student", student);
		return mv;		
	}
	/*
	 * ʱ�����ݸ�ʽ������
	 */
	@RequestMapping("testDate")
	public ModelAndView testDateFormat(@RequestParam("date") DateTest date) {
		ModelAndView mv = new ModelAndView("test/success");
		mv.addObject("date",date);
		return mv;
	}
	/*
	 * spring-mvc ʹ��json����
	 */
	@ResponseBody
	@RequestMapping("testJson")
	public List<Student> testJson(){
		Student stu1 = new Student(1,20,"zs","china");
		Student stu2 = new Student(2,20,"ls","england");
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		return list;
	}
	
	/*
	 * �ļ��ϴ�����
	 */
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("sid")  String sid,
			@RequestParam("sPicture") MultipartFile file) throws IOException {
		System.out.println("ѧ��:"+sid);
		InputStream input  = file.getInputStream();
		OutputStream out = new FileOutputStream("d:\\abc.txt");
		byte[] bs = new byte[1024];
		int len = -1;
		while((len = input.read(bs))!=-1){
		 out.write(bs,0,len);
		}
		out.close();
		input.close();
		return "test/success";
	}
	
	@RequestMapping("testException")
	public String testException() {
		int i = 0;
		i=1/0;
		return "test/success";
	}
	
/*	@ExceptionHandler({Exception.class})
	public String handleExcetion(Exception e) {
		System.out.println(e.toString());
		return "test/error";
	}*/
	
	/*
	 * ǰ��ԭ������ҳ��
	 */
	@RequestMapping("ToTest")
	public String toTest() {
		return "raw_test/test";
	}
}
