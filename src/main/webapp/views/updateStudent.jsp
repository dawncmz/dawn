<%@page import="com.cmz.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生信息页面</title>
<base href="http://localhost:8080/springWeb/"/>
<!--  -->
</head>
<body>
		<form action="student/updateStudent.mvc" method="post" >
				<% Student curStudent = (Student)request.getAttribute("curStudent");%>
				姓名<input type="text" name="sname" value=<%=curStudent.getSname()%>><br/>
				<!-- type="text"可以不写 -->
				学号<input type="text" name="sid" value=<%=curStudent.getSid()%> readonly="readonly"><br/>
				年龄<input type="text" name="sage" value=<%=curStudent.getSage()%>><br/>
				地址<input type="text" name="saddress" value=<%=curStudent.getSaddress()%>><br/>
				<!--  照片提交必须使用post数据  -->
				<input type="submit" value="更新">
		</form>
</body>
</html>