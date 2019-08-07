<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn() {
		var mgForm = document.getElementById("mgForm");
		//alert('aaa');
		mgForm.submit();
	}
	
	function updateFn(t) {
		var id = t.parentNode.parentNode.children[0].innerHTML;
		var name = t.parentNode.parentNode.children[3].innerHTML;
		var gender = t.parentNode.parentNode.children[4].innerHTML;
		var age = t.parentNode.parentNode.children[5].innerHTML;
		//alert(id);
		var url = 'UpdateShow?id='+id+"&name="+name+"&age="+age;
		//alert(url);
		window.open(url,'修改信息','width=400,height=400');
	}
	
	function deleteFn(t) {
		var id = t.parentNode.parentNode.children[0].innerHTML;
		window.location.href="Delete?id="+id;
	}
</script>
</head>
<body>
	<form action="MgShow" method="post" id="mgForm">
		用户名:<input type="text" name="username" value="${uname}">&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		真实姓名:<input type="text" name="name" value="${name}"><br>
		<input type="button" value="查询" onclick="fn()"><br>
		
	</form>
	<table border="1" cellpadding="0" width=100% bgcolor="#EEEEEE" bgcolor="#E4E4E4">
		<tr>
			<td>用户编号</td>
			<td>用户名</td>
			<td>用户密码</td>
			<td>真实姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>	
			<td>${user.uId}</td>
			<td>${user.userName}</td>
			<td>${user.pwd}</td>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.age}</td>
			<td>
				<input type="button" value="修改" onclick="updateFn(this)">&nbsp;
				<input type="button" value="删除" onclick='deleteFn(this)'>
			</td>
		</tr>	
		</c:forEach>
	</table>
</body>
</html>