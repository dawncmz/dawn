<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增学生</title>
<!-- <base href="http://106.53.68.197:8080/springWeb/"/> -->
<base href="http://localhost:8080/springWeb/"/>
</head>
<body>
		<form action="student/addStudent.mvc" method="post">
				姓名<input type="text" name="sname"><br/>
				学号<input type="text" name="sid"><br/>
				年龄<input type="text" name="sage"><br/>
				地址<input type="text" name="saddress"><br/>
				<input type="submit" value="新增">
		</form>
</body>
</html>