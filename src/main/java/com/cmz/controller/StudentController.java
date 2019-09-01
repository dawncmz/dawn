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
 * student���controller
 */
@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService ;
	@Autowired
	ScoreFormService scoreFormService ;
	/*
	 * ���ѧ��
	 */
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		if(studentService.isExist(student.getSid()))
			return TipUtil.TipFactory("��ѧ���Ѿ�����!");
		else studentService.addStudent(student);
		return TipUtil.TipFactory("������!");
	}
	/*
	 * ɾ��ѧ��
	 * ����ɾ������ֻ��ͨ������ѧ���������Բ���Ҫ����Ƿ����
	 */
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("sid") int sid) {
		studentService.deleteStudentById(sid);
		return TipUtil.TipFactory("ɾ�����!");
	}
	/*
	 * ����ѧ��
	 */
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		if(!studentService.isExist(student.getSid())) {
			return TipUtil.TipFactory("��ѧ��������,��ֱ����ӻ�ȷ��ѧ���Ƿ�������ȷ");
		}
		student.setHavePicture(studentService.queryStudentById(student.getSid()).isHavePicture());
		studentService.updateStudent(student);
		return TipUtil.TipFactory("�޸����!");
	}
/*	@RequestMapping("queryAllStudent")
	public ModelAndView queryAllStudent() {
		studentService.queryAllStudent();
	}*/
	/*
	 * ��ʾ����ѧ����ϸ��Ϣ
	 */
	@RequestMapping("ToShowSingleStudent")
	public ModelAndView toShowSingleStudent(@RequestParam("sid") int sid) {
		Student student = studentService.queryStudentWithScoreForm(sid);
		ModelAndView mv = new ModelAndView("showSingleStudent");
		mv.addObject("curStudent", student);
		return mv;
	}
	/*
	 * ��ת������ѧ����Ϣҳ��
	 */
	@RequestMapping("ToUpdateStudent")
	public ModelAndView tosUpdateStudent(@RequestParam("sid") int sid) {
		Student student = studentService.queryStudentById(sid);
		ModelAndView mv = new ModelAndView("updateStudent");
		mv.addObject("curStudent",student);
		return mv;
	}
	/*
	 * ��̬��ѯ��Ӧѧ��ѧ���Ƿ����
	 */
	@ResponseBody
	@RequestMapping("StudentIdAjax")
	public String studentIdAjax(@RequestParam("sid") int sid) {
		return studentService.isExist(sid)==true?"��ѧ������":"��ѧ��������";
	}
	/*
	 * ��ת�����ѧ��ҳ��
	 */
	@RequestMapping("ToAddStudent")
	public ModelAndView toAddStduent() {
		ModelAndView mv = new ModelAndView("addStudent");
		return mv;
	}
	/*
	 * ��ȡĳ����ҳ��ѧ��
	 */
	@ResponseBody
	@RequestMapping("getLimitStudent")
	public List<Student> getLimitStudent(@RequestParam("curPage")int curPage,@RequestParam("pageSize") int pageSize,
			HttpSession session) {
		session.setAttribute("curPage", curPage);
		return studentService.queryStudentByPage(curPage, pageSize);
	}
}
