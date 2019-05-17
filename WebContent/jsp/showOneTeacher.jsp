<%@ page import="teacher.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	Teacher teacher = (Teacher) request.getAttribute("teacher");
	Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
	System.out.print(currentPage);
%>
<meta charset="UTF-8">
<title>查看一个老师</title>
<link rel="stylesheet" href="css/showAllTeachers.css">
<link rel="stylesheet" href="css/addTeacher.css">
</head>
<body>
	<div id="body">
		<div id="title">
			<div>
				<hr>
			</div>
			<div>
				<h3>查看一个老师信息</h3>
			</div>
			<div>
				<hr>
			</div>
		</div>
		<table id="teaTable">
			<tr>
				<td>id</td>
				<td><%=teacher.getId()%></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><%=teacher.getName()%></td>
			</tr>
			<tr>
				<td>学院</td>
				<td><%=teacher.getCollege()%></td>
			</tr>
			<tr>
				<td>专业</td>
				<td><%=teacher.getProfession()%></td>
			</tr>
			<tr>
				<td>年级</td>
				<td><%=teacher.getGrade()%></td>
			</tr>
			<tr>
				<td>薪水</td>
				<td><%=teacher.getSalary()%></td>
			</tr>
			<tr>
				<td>薪水</td>
				<td><%=teacher.getAge()%></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" style="font-size: 20px;"
				onclick="window.location.href = './ShowAllTeacher?currentPage=<%=currentPage%>'"></td>
			</tr>
		</table>
	</div>
</body>
</html>