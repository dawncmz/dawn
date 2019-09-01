<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <base href="http://106.53.68.197:8080/springWeb/"/> -->
<base href="http://localhost:8080/springWeb/"/>
</head>
<body>
		<form action="scoreForm/updateScoreForm.mvc" method="post" >
				id:<input type="text" name="sid" value=${requestScope.scoreForm.sid } readonly="readonly"><br/>
				<!-- type="text"可以不写 -->
				数学成绩:<input type="text" name="math" value=${requestScope.scoreForm.math } ><br/>
				英语成绩:<input type="text" name="english" value=${requestScope.scoreForm.english }><br/>
				语文成绩:<input type="text" name="chinese" value=${requestScope.scoreForm.chinese }><br/>
				科学成绩:<input type="text" name="science" value=${requestScope.scoreForm.science }><br/>
				<!--  照片提交必须使用post数据  -->
				<input type="submit" value="更新"> 
		</form>	
</body>
</html>