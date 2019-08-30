package com.cmz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.cmz.entity.Student;
import com.cmz.serviceImpl.StudentService;
@Controller
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	StudentService studentService ;
	
	@RequestMapping("Welcome")
	public ModelAndView welcome(@RequestParam(value="curPage",defaultValue="1") int curPage,
			@RequestParam(value="pageSize",defaultValue="3") int pageSize,HttpSession session) {
		ModelAndView mv = new ModelAndView("index");
		List<Student> list = studentService.queryStudentByPage(curPage, pageSize);
		int count = studentService.queryStudentCount();
		int maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
		mv.addObject("pageSize", pageSize);
		mv.addObject("students", list);
		mv.addObject("curPage", curPage);
		session.setAttribute("curPage", curPage);
		mv.addObject("maxPage", maxPage);
		mv.addObject("count", count);
		return mv;
	}
	
	
}
