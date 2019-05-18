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
<script type="text/javascript" src="../js/teacher.js"></script>
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
			method="post" name="teacherForm">
			<table id="teaTable">
				<tr>
					<td>id自增</td>
					<td></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name" maxlength="20"></td>
				</tr>
				<tr>
					<td>学院</td>
					<td>
						<select name="college"
							onchange="fillProfession()" id="college">
								<option value="">请选择</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<select name="profession"  id="profession">
								<option value="">请选择</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>年级</td>
					<td>
						<select name="grade">
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>薪水</td>
					<td><input name="salary" type="number" step="0.01" min="0"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age" type="number" min="20" max="60" name="points" style="width: 156px;"></td>
				</tr>
				<tr>
					<td><input type="submit" style="font-size: 20px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>