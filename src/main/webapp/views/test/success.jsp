<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 welcome to springmvc<br/>
 	modelAndView测试查询<br/>
 	${requestScope.student.sid }<br/>
 	${requestScope.student.sname }<br/>
 	${requestScope.student.sage }<br/>
 	${requestScope.student.saddress }<br/>
 	
 	${requestScope.date.date }
</body>
</html>