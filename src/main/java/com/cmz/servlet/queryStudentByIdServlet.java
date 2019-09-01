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
 * ������servlet
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
		response.setCharacterEncoding("utf-8");//���ô�request��ȡ�õ�ֵ������ݿ���ȡ����ֵ
		response.setContentType("text/html; charset=UTF-8");//��jspͷ�������ñ���һ�£�����ҳ����Ϊ���ı���
		request.setCharacterEncoding("utf-8");				//����ע�����ߵ�����һ��Ҫ��д������֮ǰ
		
		int sid = 201601;
		Student student = studentService.queryStudentById(sid);
		response.getWriter().write(student.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
