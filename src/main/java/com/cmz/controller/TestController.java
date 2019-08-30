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
 * mvc测试控制器
 */
@Controller
@RequestMapping("Test")
public class TestController {
	
	StudentService studentService ;
	/*
	 * mvc启动测试
	 */
	@RequestMapping("mvctest")
	public String welcome(){
		return "test/success";
	}
	/*
	 * requestParam 注解测试
	 */
	@RequestMapping("addStudent")
	public String addStudent(@RequestParam("sname") String sname,@RequestParam("sid") int sid,
			@RequestParam("sage") int sage,@RequestParam("saddress") String saddress) {
		Student student = new Student(sid,sage,sname,saddress);
		System.out.println(student);
		return "test/addStudent";
	}
	/*
	 * 字段自动装配对象测试
	 * 必须满足 字段名相同的条件
	 */
	@RequestMapping("addStudent2")
	public String addStudent2(Student student) {
		System.out.println(student.toString());
		return "test/addStudent";
	}
	/*
	 * modelAndView测试
	 */
	@RequestMapping("queryStudentById")
	public ModelAndView queryStudentById() {
		ModelAndView mv= new ModelAndView("test/success");//会自动加上前缀和后缀
		Student student = new Student(201601,20,"cmz","china");
		mv.addObject("student", student);
		return mv;
	}
	/*
	 * converter测试
	 * 可见是spring自己去寻找可用的转换器而不用显示指定
	 */
	@RequestMapping("testConverter")
	public ModelAndView testConverter(@RequestParam("studentInfo") Student student) {
		ModelAndView mv= new ModelAndView("test/success");//会自动加上前缀和后缀
		mv.addObject("student", student);
		return mv;		
	}
	/*
	 * 时间数据格式化测试
	 */
	@RequestMapping("testDate")
	public ModelAndView testDateFormat(@RequestParam("date") DateTest date) {
		ModelAndView mv = new ModelAndView("test/success");
		mv.addObject("date",date);
		return mv;
	}
	/*
	 * spring-mvc 使用json测试
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
	 * 文件上传测试
	 */
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("sid")  String sid,
			@RequestParam("sPicture") MultipartFile file) throws IOException {
		System.out.println("学号:"+sid);
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
	 * 前往原生测试页面
	 */
	@RequestMapping("ToTest")
	public String toTest() {
		return "raw_test/test";
	}
}
