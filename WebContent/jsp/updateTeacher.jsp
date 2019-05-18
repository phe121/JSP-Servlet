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
			method="post" name="teacherForm">
			<table id="teaTable">
				<tr>
					<td><input name="id" type="hidden"
						value="<%=teacher.getId()%>"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name" value="<%=teacher.getName()%>" maxlength="20"></td>
				</tr>
				<tr>
					<td>学院</td>
					<td>
						<select name="college"
							onchange="fillProfession()" id="college">
								<option value="<%=teacher.getCollege()%>"><%=teacher.getCollege()%></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<select name="profession"  id="profession">
								<option value="<%=teacher.getProfession()%>"><%=teacher.getProfession()%></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>年级</td>
					<td>
						<select name="grade">
							<option value="<%=teacher.getGrade()%>"><%=teacher.getGrade()%></option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>薪水</td>
					<td><input name="salary" value="<%=teacher.getSalary()%>" type="number" step="0.01" min="0"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age" value="<%=teacher.getAge()%>" name="age" type="number" min="20" max="60" name="points" style="width: 156px;"></td>
				</tr>
				<tr>
					<td><input type="submit" style="font-size: 20px;"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/teacher.js"></script>
</html>