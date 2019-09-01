package com.cmz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cmz.entity.Student;
import com.cmz.service.IScoreFormService;
import com.cmz.service.IStudentService;
import com.cmz.serviceImpl.ScoreFormService;
import com.cmz.serviceImpl.StudentService;
import com.cmz.util.TipUtil;
/*
 * student相关controller
 */
@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService ;
	@Autowired
	ScoreFormService scoreFormService ;
	/*
	 * 添加学生
	 */
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		if(studentService.isExist(student.getSid()))
			return TipUtil.TipFactory("该学生已经存在!");
		else studentService.addStudent(student);
		return TipUtil.TipFactory("添加完成!");
	}
	/*
	 * 删除学生
	 * 由于删除操作只能通过已有学生进行所以不需要检查是否存在
	 */
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("sid") int sid) {
		studentService.deleteStudentById(sid);
		return TipUtil.TipFactory("删除完成!");
	}
	/*
	 * 更新学生
	 */
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		if(!studentService.isExist(student.getSid())) {
			return TipUtil.TipFactory("该学生不存在,请直接添加或确认学号是否输入正确");
		}
		student.setHavePicture(studentService.queryStudentById(student.getSid()).isHavePicture());
		studentService.updateStudent(student);
		return TipUtil.TipFactory("修改完成!");
	}
/*	@RequestMapping("queryAllStudent")
	public ModelAndView queryAllStudent() {
		studentService.queryAllStudent();
	}*/
	/*
	 * 显示单个学生详细信息
	 */
	@RequestMapping("ToShowSingleStudent")
	public ModelAndView toShowSingleStudent(@RequestParam("sid") int sid) {
		Student student = studentService.queryStudentWithScoreForm(sid);
		ModelAndView mv = new ModelAndView("showSingleStudent");
		mv.addObject("curStudent", student);
		return mv;
	}
	/*
	 * 跳转到跟新学生信息页面
	 */
	@RequestMapping("ToUpdateStudent")
	public ModelAndView tosUpdateStudent(@RequestParam("sid") int sid) {
		Student student = studentService.queryStudentById(sid);
		ModelAndView mv = new ModelAndView("updateStudent");
		mv.addObject("curStudent",student);
		return mv;
	}
	/*
	 * 动态查询对应学号学生是否存在
	 */
	@ResponseBody
	@RequestMapping("StudentIdAjax")
	public String studentIdAjax(@RequestParam("sid") int sid) {
		return studentService.isExist(sid)==true?"该学生存在":"该学生不存在";
	}
	/*
	 * 跳转到添加学生页面
	 */
	@RequestMapping("ToAddStudent")
	public ModelAndView toAddStduent() {
		ModelAndView mv = new ModelAndView("addStudent");
		return mv;
	}
	/*
	 * 获取某个分页的学生
	 */
	@ResponseBody
	@RequestMapping("getLimitStudent")
	public List<Student> getLimitStudent(@RequestParam("curPage")int curPage,@RequestParam("pageSize") int pageSize,
			HttpSession session) {
		session.setAttribute("curPage", curPage);
		return studentService.queryStudentByPage(curPage, pageSize);
	}
}
