<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="picPath" value="http://127.0.0.1:8081/ssmImg"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/deleSelectedUser.do" method="post">
		<table align="center" border="1" >
			<tr align="center"><input type="submit" value="批量删除"/></tr>
		
			<tr>
			<td>全选</td>
			<td>姓名</td>
			<td>图片</td>
			<td>密码</td>
			<td>年龄</td>
			<td>地址</td>
			<td>操作</td>				
			</tr>
			<c:forEach items="${list}" var="list">
			
			<tr>
			<td><input type="checkbox" name="id" value="${list.id}"> </td>
			<td>${list.name}</td>
			<td><img src="${picPath}${list.pic}" height="100" width="100"></td>
			
			<td>${list.pwd}</td>
			<td>${list.age}</td>
			<td>${list.address}</td>
			<td>
			<a href="findUserById.do?id=${list.id}">修改</a><a href="deleteUserById.do?id=${list.id}">删除</a>
			</td>
							
			</tr>
			
			</c:forEach>
		</table>
	
	</form>
</body>
</html>