package com.cmz.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cmz.entity.Student;
import com.cmz.service.IStudentService;
import com.cmz.util.TipUtil;

@RequestMapping("Picture")
@Controller
public class PictureController {
	@Autowired
	IStudentService studentService ;
	
	@RequestMapping("toUploadPicture")
	public String toUploadPicture() {
		return "uploadPicture";
	}
	@RequestMapping("uploadPicture")
	public ModelAndView uploadPicture(@RequestParam("sid")  int sid,
			@RequestParam("sPicture") MultipartFile file) throws IOException {
		Student student = studentService.queryStudentById(sid);
		if(student==null)
			return TipUtil.TipFactory("���޴���");
		InputStream input  = file.getInputStream();
		OutputStream out = new FileOutputStream("c:\\web_pos\\"+sid+".png");
		byte[] bs = new byte[1024];
		int len = -1;
		while((len = input.read(bs))!=-1){
		 out.write(bs,0,len);
		}
		out.close();
		input.close();
		if(student.isHavePicture()==false) {
			studentService.readyHavePicture(sid);
			return TipUtil.TipFactory("�ϴ��ɹ�");
		}
		else {
			studentService.readyHavePicture(sid);
			return TipUtil.TipFactory("�Ѹ��Ǹ�ѧ��������Ƭ");
		}
	}
	
	@RequestMapping("getPicture")
	public  ModelAndView getPicture(@RequestParam("sid") int sid) throws IOException{
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        
		if(!studentService.isHavePicture(sid)) {
			return TipUtil.TipFactory("��ѧ����δ�ϴ���Ƭ!");
		}
		
/*        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + "��Ĵ洢�ĵ�ַ";*/
		//����������Ŀ���ļ��ķ�ʽ
		String fileName = sid+".png";
		InputStream in  = new FileInputStream("c:\\web_pos\\"+fileName);
		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[10];
		while((in.read(bs))!=-1) {
			out.write(bs);
		}
		in.close();
		out.close();
		return null;
	}
	
}
