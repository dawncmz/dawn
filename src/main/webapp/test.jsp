<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){  //这json的括号是真的烦人
		$("#jsonTest").click(function(){
			debugger;
			$.post(
				"Test/testJson.mvc",
				function(result){
					for(var i=0;i<result.length;i++)
						alert(result[i].sid+"--"+result[i].sname+"--"+result[i].sage+"--"+result[i].saddress);
				}
			); 
		});
	})

</script>

<title>test</title>
</head>
<body>
	<a href="queryStudentByIdServlet">原生servlet</a><br>
	<a href="Test/mvctest.mvc">mvcTest</a><br/>
	<a href="Test/queryStudentById.mvc">查询cmz</a>
	<form action="Test/addStudent2.mvc" method="post">
			姓名<input type="text" name="sname"><br/>
			学号<input type="text" name="sid"><br/>
			年龄<input type="text" name="sage"><br/>
			地址<input type="text" name="saddress"><br/>
			<input type="submit" value="新增">
	</form><br/>
	<a href="moban3921/index.html">模板</a>
	
	<form action="Test/testConverter.mvc" method="post">
		学生信息<input type="text" name="studentInfo"><br/>
		<input type="submit" value="提交">
	</form><br/>
	<form action="Test/testDate.mvc" method="post">
		输入日期<input type="text" name="date"><br/>
		<input type="submit" value="提交">
	</form><br/>
	
	<input  id="jsonTest" value="jsonTest" type="button"><br/>
	
	<!-- 文件上传测试  -->
	<form action="Test/testUpload.mvc" method="post" enctype="multipart/form-data">
				学号<input type="text" name="sid" ><br/>
				上传照片<input type="file" name="sPicture"><br/>
				<!--  照片提交必须使用post数据  -->
				<input type="submit" value="提交">
	</form><br/>
	<a href="Test/testException.mvc">exception测试</a>
</body>
</html>

