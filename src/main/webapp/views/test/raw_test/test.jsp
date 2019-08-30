<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<title>测试页面</title>
</head>
<body>
	======test======<br/>
	${requestScope.student}<br/>
	测试不存在的变量  :   ${requestScope.xxx }<br/>
	<c:out  value = "${requestScope.student}" default="notFound" /><br/>
	tomcat路径 :<br/>
	request.getContextpath()= <%=request.getContextPath() %><br/>
	application.getRealPath()= <%=application.getRealPath("/")%><br/>
	<a href="DispatcherServlet?To=/viewsOfTest/sessionInvalidate.jsp">session注销测试</a><br/>
	<a href="DispatcherServlet?To=/viewsOfTest/SessionBindingTest.jsp">session绑定测试</a><br/>
	<a href="DispatcherServlet?To=/viewsOfTest/SessionActivationTest.jsp">session钝化活化测试</a><br/>
	
	
	原生Ajax测试<br/>
	学号:<input id="sid"><br/>
	<input type="button" value="查询" onclick="checkSid()"/>
	<script>
	function checkSid(){
		var qid = document.getElementById("sid").value;
		xhr = new XMLHttpRequest(); 
		xhr.onreadystatechange = callback; 
		xhr.open("post","StudentIdAjaxServlet",true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("sid="+qid);
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var data = xhr.responseText;
			alert(data);
		}
	}
	</script>
	
	
	jqury--ajax测试<br/>
	学号:<input id="sid2"><br/>
	<input type="button" value="查询" onclick="checkSid2()"/>
	<script>
		function checkSid2(){
			debugger;
			var  sid2 = $("#sid2").val();
			$.ajax({
				url:"StudentIdAjaxServlet",
				method:"post",
				data: "sid="+sid2,
				success :function(result,testStatus){
					alert(result);
				},
				error :function(xhr,errorMessage,e){
					alert("系统错误");
				}
			});
		}
	</script>
	
	
	
	jqury--ajax--load测试<br/>
	学号:<input id="sid3"><br/>
	<input type="button" value="查询" onclick="checkSid3()"/>
	<span id="span1"></span>
	<script>
		function checkSid3(){
			var  sid3 = $("#sid3").val();
			$("#span1").load(
				"StudentIdAjaxServlet",
				"sid="+sid3
			);
		}
	</script><br/>
	
	
	json 返回测试 <br/>
	学号:<input id="sid4"><br/>
	<input type="button" value="从后台获取json对象" onclick="test()"/><br/>	
	<script>
		function test(){
			debugger;
			var sid4=$("#sid4").val();
 			$.get(
				"JsonTestServlet",
				"sid="+sid4,
				function(result){
					/* var student = JSON.parse(result); */
					var student = eval(result);
					alert(student.id+"--"+student.name+"--"+studen.age+"--"+student.address);
				}
			); 
		}
	</script>
	
	
	jqury--ajax--get 测试<br/>
	学号:<input id="sid5"><br/>
	<input type="button" value=".get查询" onclick="getQuery()"/><br/>	
	<script>
		function getQuery(){
			var sid5=$("#sid5").val();
  			$.get(
				"JsonTestServlet",
				"sid="+sid5,
				function(result){
					var data = JSON.parse(result);
					alert(data.stu.id+"--"+
							data.stu.name+"--"+
							data.stu.age+"--"+
							data.stu.address);
				}
 			); 
		}
	</script>
	
</body>
</html>