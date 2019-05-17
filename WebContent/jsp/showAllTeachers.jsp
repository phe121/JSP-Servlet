<%@ page import="teacher.entity.Teacher"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	@SuppressWarnings("unchecked")
	List<Teacher> currentPageTheachers = (List<Teacher>) request.getAttribute("currentPageTheachers");
	@SuppressWarnings("unchecked")
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
	Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
	int serialNumber = (currentPage - 1) * 10 + 1;
%>
<head>
<meta charset="UTF-8">
<title>教师信息管理系统</title>
<link rel="stylesheet" href="css/showAllTeachers.css">
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/deleteTeachers.js"></script>
</head>
<body>
	<input id="currentPage" name="currentPage" type="hidden" value=<%=currentPage%>>
	<input id="teachersNumbers" name="teachersNumbers" type="hidden" value=<%=teachers.size()%>>
		<div id="body">
		<div id="title">
			<div>
				<hr>
			</div>
		<div>
				<h3>教师信息管理系统</h3>
			</div> <div>
				<hr>
			</div>
	</div>
	<div id="option" style="margin-top: 20px;">
		<input type="button" value="新增"
			style="background-color: rgb(92, 184, 92);"
			onclick="window.location.href = './jsp/addTeacher.jsp?serialNumber=<%=teachers.size()%>'">     <!-- 新增是id自增 -->
		<input type="button" value="删除" style="background-color: red"
			onclick="deleteTeachers()"> <input type="button"
			value="按id排序" style="background-color: rgb(0, 51, 255);"
			onclick="window.location.href = './SortById?currentPage=<%=currentPage%>'">
		<input type="button" value="按年龄安排序"
			style="background-color: rgb(255, 255, 0); width: 100px;"
			onclick="window.location.href = './SortByAge?currentPage=<%=currentPage%>'">
	</div>
	<table id="teaTable">
		<tr style="background-color: rgb(218, 222, 225)">
			<td><input type="checkbox" name="currentPageTheachers"
				onclick="selectTeachers()"></td>
			<td>序号</td>
			<td>id</td>
			<td>姓名</td>
			<td>学院</td>
			<td>专业</td>
			<td>年级</td>
			<td>薪水</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<%
			for (Teacher currentPageTheacher : currentPageTheachers) {
		%>
		<tr>
			<td><input type="checkbox" name="teachers"
				value=<%=currentPageTheacher.getId()%> onclick="selectTeacher()"></td>
			<td><%=serialNumber++%></td>
			<td><%=currentPageTheacher.getId()%></td>
			<td><%=currentPageTheacher.getName()%></td>
			<td><%=currentPageTheacher.getCollege()%></td>
			<td><%=currentPageTheacher.getProfession()%></td>
			<td><%=currentPageTheacher.getGrade()%></td>
			<td><%=currentPageTheacher.getSalary()%></td>
			<td><%=currentPageTheacher.getAge()%></td>
			<td class="operate"><input type="button" value="查看"
				style="color: red"
				onclick="window.location.href = './ShowOneTeacher?id=<%=currentPageTheacher.getId()%>&currentPage=<%=currentPage%>'">
				<input type="button" value="修改" style="color: red"
				onclick="window.location.href = './UpdateTeacher?id=<%=currentPageTheacher.getId()%>&currentPage=<%=currentPage%>'">
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<div id="bottom">
		<div id="massage">
			第<%=currentPage%>页
			共<%=teachers.size()%>条
		</div>
		<div id="inputMassage">
			请输入页数<input type="text" value="" id= "inputPage" style="width:150px;"><input type="button" value="跳转" onclick="turnPage()">
			<input type="button" value="全部删除"> 
		</div>
		<div>
			<input type="button" id="up" value="上一页"
				style="background-color: green; margin-right: 20px; color: white;"
				onclick="upPage()"> <input type="button" id="down"
				value="下一页" style="background-color: red; color: white;"
				onclick="nextPage()">
		</div>
	</div>
	</div>
</body>
</html>