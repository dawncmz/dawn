<%@page import="com.cmz.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主界面/全部学生信息</title>
<base href="http://localhost:8080/springWeb/"/> 
<script src="https://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
	<table border="1px" id="tb">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>删除</th>
			<th>更新信息</th>
			<th>照片</th>
			<th>成绩操作</th>
		</tr>
		<%
			List<Student> s = (List<Student>)request.getAttribute("students");
			for(int i=0;i<s.size();i++){
		%>
			<tr>
				<td><%=s.get(i).getSid() %></td>
				<td><%=s.get(i).getSname() %></td>
				<td><%=s.get(i).getSage() %></td>
				<td><%=s.get(i).getSaddress() %></td>
				<%-- <td><a href="DeleteStudentServlet?sid=<%=curStudent.getId()%>">删除</a></td> --%>
				<td><a id="s<%=i%>1" href="views/deleteConfirm.jsp?sid=<%=s.get(i).getSid()%>">删除</a></td>
				<td><a id="s<%=i%>2" href="student/ToUpdateStudent.mvc?sid=<%=s.get(i).getSid()%>">更新信息</a></td>
				<td><a id="s<%=i%>3" href="Picture/getPicture.mvc?sid=<%=s.get(i).getSid() %>">获取照片</a></td>
				<td><a id="s<%=i%>4" href="student/ToShowSingleStudent.mvc?sid=<%=s.get(i).getSid()%>">成绩操作</a></td>
			</tr>
		<%
			}
			//int curPage = (Integer)request.getAttribute("curPage");
			int curPage = (Integer)session.getAttribute("curPage");
			int maxPage = (Integer)request.getAttribute("maxPage");
			int count = (Integer)request.getAttribute("count");
			int lastPage = curPage==1?1:curPage-1;
			int nextPage = curPage==maxPage?curPage:curPage+1;
			int pageSize = (Integer)request.getAttribute("pageSize");
		%>
	</table>
	
	<!-- 页面刷新翻页 -->
<%-- 	<a href="Admin/Welcome.mvc?curPage=1">首页</a>
	<a href="Admin/Welcome.mvc?curPage=<%=lastPage%>">上一页</a>
	<%="当前第"+curPage+"页" %>
	<a href="Admin/Welcome.mvc?curPage=<%=nextPage%>">下一页</a>
	<a href="Admin/Welcome.mvc?curPage=<%=maxPage%>">尾页</a><br/>
	<%="共"+maxPage+"页"+"("+count+"条记录)" %><br/> --%>
	
	<!-- ajax实现 -->
	<input type="button" value="首页" onclick="firstPage()"/>
	<input type="button" value="上一页" onclick="lastPage()"/>
	<i id="cur">当前第${sessionScope.curPage }页</i>
	<input type="button" value="下一页" onclick="nextPage()"/>
	<input type="button" value="尾页" onclick="theLastPage()"/>
	<i id="inf" >共${requestScope.maxPage }页(${requestScope.count }条记录)</i>
	
	
	
	<script>
	curPage = <%=curPage%>;
	maxPage = <%=maxPage%>;
	pageSize = <%=pageSize%>;
	function firstPage(){
		curPage=1;
			$.get(
			"student/getLimitStudent.mvc",
			{curPage:curPage,pageSize:pageSize},
			function(result){
				set(result);		
			}
		); 
	}	
	function lastPage(){
		curPage=curPage==1?1:curPage-1;
			$.get(
			"student/getLimitStudent.mvc",
			{curPage:curPage,pageSize:pageSize},
			function(result){
				set(result);
			}
		); 
	}
	function nextPage(){
		curPage=curPage==maxPage?maxPage:curPage+1;
			$.get(
			"student/getLimitStudent.mvc",
			{curPage:curPage,pageSize:pageSize},
			function(result){
				set(result);
			}
		); 
	}
	function theLastPage(){
		curPage=maxPage;
			$.get(
			"student/getLimitStudent.mvc",
			{curPage:curPage,pageSize:pageSize},
			function(result){
				/* var student = JSON.parse(result); */
				set(result);
			}
		); 
	}
	function set(result){
        for(var i=0;i < result.length;i++){
            var x=document.getElementById('tb');
            x.rows[i+1].cells[0].innerHTML=result[i].sid;
            x.rows[i+1].cells[1].innerHTML=result[i].sname;
            x.rows[i+1].cells[2].innerHTML=result[i].sage;
            x.rows[i+1].cells[3].innerHTML=result[i].saddress;
            document.getElementById("s"+i+1).setAttribute("href","views/deleteConfirm.jsp?sid="+result[i].sid); 
            document.getElementById("s"+i+2).setAttribute("href","student/ToUpdateStudent.mvc?sid="+result[i].sid); 
            document.getElementById("s"+i+3).setAttribute("href","Picture/getPicture.mvc?sid="+result[i].sid); 
            document.getElementById("s"+i+4).setAttribute("href","student/ToShowSingleStudent.mvc?sid="+result[i].sid); 
            document.getElementById("cur").innerHTML="当前第"+curPage+"页";
        }
        if(result.length<pageSize){
        	for(var i=result.length;i<pageSize;i++){
            var x=document.getElementById('tb');
            x.rows[i+1].cells[0].innerHTML="无";
            x.rows[i+1].cells[1].innerHTML="无";
            x.rows[i+1].cells[2].innerHTML="无";
            x.rows[i+1].cells[3].innerHTML="无";
            document.getElementById("s"+i+1).setAttribute("href",""); 
            document.getElementById("s"+i+2).setAttribute("href",""); 
            document.getElementById("s"+i+3).setAttribute("href",""); 
            document.getElementById("s"+i+4).setAttribute("href",""); 
        	}
        }
	}
	</script><br/>
	
	
	<a href="student/ToAddStudent.mvc">新增学生</a><br/>
	
	
	
	<!-- 查询框动态查询功能 -->
	<script type="text/javascript">
	//原生实现
/* 		function checkSid(){
			var qid = document.getElementById("AjaxQid").value;
			xhr = new XMLHttpRequest(); 
			xhr.onreadystatechange = callback; 
			xhr.open("post","student/StudentIdAjax.mvc",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.send("sid="+qid);
		}
		function callback(){
			if(xhr.readyState==4 && xhr.status==200){
				var data = xhr.responseText;
				document.getElementById("exist").innerHTML=data;
			}
		} */
		//jqury实现
		function checkSid(){
			var qid = document.getElementById("AjaxQid").value;
			$.get(
				"student/StudentIdAjax.mvc",
				{sid:qid},
				function(result){
					document.getElementById("exist").innerHTML=result;
				}
			); 			
		}
	
	</script>
	
	<p id="exist">请输入要查询的学生id</p>
 	<form action="student/ToShowSingleStudent.mvc" method="post">
				查询学号<input type="text" name="sid" id="AjaxQid" onkeyup="checkSid()">
				<input type="submit" value="查询">
	</form><br/> 
	
	
	
	<a href="Picture/toUploadPicture.mvc">上传照片</a><br/>
	<a href="#">返回简历页面</a><br/>
	<a href="views/test/raw_test/test.jsp">测试页面</a>
	
</body>
</html>