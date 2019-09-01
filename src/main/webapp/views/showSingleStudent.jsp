<%@page import="com.cmz.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询结果</title>
<!-- <base href="http://106.53.68.197:8080/springWeb/"/> -->
<base href="http://localhost:8080/springWeb/"/>
</head>
<body>
	<%
		Student curStudent = (Student)request.getAttribute("curStudent");
	%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>数学成绩</th>
			<th>英语成绩</th>
			<th>语文成绩</th>
			<th>科学成绩</th>
		</tr>
			<tr>
				<td><%=curStudent.getSid() %></td>
				<td><%=curStudent.getSname() %></td>
				<td><%=curStudent.getSage() %></td>
				<td><%=curStudent.getSaddress() %></td>
				<td>${requestScope.curStudent.scoreForm.math}</td>
				<td>${requestScope.curStudent.scoreForm.english}</td>
				<td>${requestScope.curStudent.scoreForm.chinese }</td>
				<td>${requestScope.curStudent.scoreForm.science }</td>
			</tr>
	</table>
	<a href="Admin/Welcome.mvc">返回首页</a><br/>
	<a href="scoreForm/toUpdateScoreForm.mvc?sid=<%=curStudent.getSid()%>">修改成绩</a>
</body>
</html>