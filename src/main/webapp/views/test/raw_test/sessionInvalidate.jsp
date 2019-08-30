<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session销毁页面</title>
</head>
<body>
	<c:out value="==========销毁session=========="/>
	<%
		session.invalidate();
	%>
</body>
</html>