<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师信息管理系统</title>
</head>
<body>
	<div id="body">
		<h2>教师信息管理系统</h2>
		<form action="../Login" method="post">
			账号:<input type="text" name="account"> <br>
			密码:<input type="password" name="password"> <br>
			<input type="submit" value="登录" id="submit">
		</form>
	</div>
</body>
<style>
*{
	padding: 0;
	margin: 0;
	background-color: rgb(240, 246, 233);
}
#body{
	text-align: center;
}
h2{
	margin: 20px;
	margin-top: 200px;
}
input {
	margin: 20px;
	border: 1px solid rgb(115, 215, 180);
}
#submit{
	width: 100px;
}
</style>
</html>