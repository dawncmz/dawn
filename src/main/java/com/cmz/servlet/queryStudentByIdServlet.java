package com.cmz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cmz.entity.Student;
import com.cmz.service.IStudentService;
import com.cmz.serviceImpl.StudentService;
/*
 * 测试用servlet
 */
public class queryStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IStudentService studentService ;
    
    public queryStudentByIdServlet() {
        super();
    }
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		studentService = (StudentService)context.getBean("studentService");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");//设置从request中取得的值或从数据库中取出的值
		response.setContentType("text/html; charset=UTF-8");//与jsp头部的设置保持一致，设置页面中为中文编码
		request.setCharacterEncoding("utf-8");				//并且注意两者的设置一定要在写入数据之前
		
		int sid = 201601;
		Student student = studentService.queryStudentById(sid);
		response.getWriter().write(student.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
