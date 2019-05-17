<%@ page import="teacher.entity.Teacher"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	Integer serialNumber = Integer.valueOf(request.getParameter("serialNumber"));
	Integer currentPage = (serialNumber % 10 == 0) ? (serialNumber / 10) : (serialNumber / 10 + 1);
%>
<meta charset="UTF-8">
<title>新增一个老师</title>
<link rel="stylesheet" href="../css/showAllTeachers.css">
<link rel="stylesheet" href="../css/addTeacher.css">
</head>
<body>
	<div id="body">
		<div id="title">
			<div>
				<hr>
			</div>
			<div>
				<h3>新增一个老师信息</h3>
			</div>
			<div>
				<hr>
			</div>
		</div>
		<form action="../AddTeacher?currentPage=<%=currentPage%>"
			method="post">
			<table id="teaTable">
				<tr>
					<td>id自增</td>
					<td></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name"></td>
				</tr>
				<tr>
					<td>学院</td>
					<td><input name="college"></td>
				</tr>
				<tr>
					<td>专业</td>
					<td><input name="profession"></td>
				</tr>
				<tr>
					<td>年级</td>
					<td><input name="grade"></td>
				</tr>
				<tr>
					<td>薪水</td>
					<td><input name="salary"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age"></td>
				</tr>
				<tr>
					<td><input type="submit" style="font-size: 20px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>