<%@page import="com.cmz.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>照片上传</title>
<base href="http://localhost:8080/springWeb/"/>
</head>
<body>
		<form action="Picture/uploadPicture.mvc" method="post" enctype="multipart/form-data">
				<!-- 姓名<input type="text" name="sname" ><br/> -->
				学号<input type="text" name="sid"><br/>
				上传照片<input type="file" name="sPicture"><br/>
				<!--  照片提交必须使用post数据  -->
				<input type="submit" value="更新">
		</form><br/>
		
		<a href="Admin/Welcome.mvc"> 返回首页 </a>
</body>
</html>