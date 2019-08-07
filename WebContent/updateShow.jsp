<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<script type="text/javascript">
	function myFunction() {
		var elem = document.getElementById("f1");
		elem.submit();
		//window.opener.location.reload();//从服务器重新加载
		//window.close();
		
		
	}
	
</script>
</head>
<body>
	<form action="UpdateServlet" method="post" id="f1">
	<input type="hidden" name="uid" value="${uid}">
	<table border=1px align="center" width="300px" height="300px" bgcolor="#E4E4E4">
			
			<tr align="center">
				<td>修改姓名</td>
				<td>
					<input type="text" name="name" id="n1" value="${name}">
				</td>
			</tr>
			<tr align="center">
				<td>修改性别</td>
				<td>
					<input type="radio" name="gender" value="male" checked="checked">男&nbsp;
					<input type="radio" name="gender" value="female">女
				</td>
			</tr>
			<tr align="center">
				<td>修改年龄</td>
				<td>
					<input type="text" name="age" id="a1" value="${age}">岁
				</td>
			</tr>
			<tr align="center">
				<td>
					<input type="button" value="提交" onclick="myFunction()">
				</td>
				<td>
					<input type="reset" name="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>