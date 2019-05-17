<%@ page import="teacher.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	Teacher teacher = (Teacher) request.getAttribute("teacher");
	Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
%>
<meta charset="UTF-8">
<title>修改一个老师</title>
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
				<h3>修改一个老师信息</h3>
			</div>
			<div>
				<hr>
			</div>
		</div>
		<form action="./SaveTeacher?currentPage=<%=currentPage%>"
			method="post">
			<table id="teaTable">
				<tr>
					<td><input name="id" type="hidden"
						value="<%=teacher.getId()%>"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name" value="<%=teacher.getName()%>"></td>
				</tr>
				<tr>
					<td>学院</td>
					<td><input name="college" value="<%=teacher.getCollege()%>"></td>
				</tr>
				<tr>
					<td>专业</td>
					<td><input name="profession"
						value="<%=teacher.getProfession()%>"></td>
				</tr>
				<tr>
					<td>年级</td>
					<td><input name="grade" value="<%=teacher.getGrade()%>"></td>
				</tr>
				<tr>
					<td>薪水</td>
					<td><input name="salary" value="<%=teacher.getSalary()%>"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age" value="<%=teacher.getAge()%>"></td>
				</tr>
				<tr>
					<td><input type="submit" style="font-size: 20px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>