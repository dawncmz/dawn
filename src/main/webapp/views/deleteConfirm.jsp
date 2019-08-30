<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除确认</title>
<base href="http://localhost:8080/springWeb/"/>
</head>
<body>
	删除的学生信息无法复原  确认删除吗? 
	<% 
		String curId =request.getParameter("sid");
	%>
	<form action="student/deleteStudent.mvc" method="post">
				学号<input type="text" name="sid" value=<%=curId%> readOnly="readOnly">
				<input type="submit" value="确认">
	</form><br/>
	
	<a href="Admin/Welcome.mvc">返回首页</a>
</body>
</html>