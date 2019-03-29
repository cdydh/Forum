<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Entity.User" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/stulist.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0" align="center" cellspacing="0" class="list_table"
		id="senfe" style='width: 90%'>
		<thead>
			<tr>
				<td colspan='4'>
					<div align="center">学生信息表</div>
				</td>
			</tr>
			<tr>
				<th>用户名</th>
				<th>密    码</th>
				<th>性    别</th>
				<th>学    校</th>
			</tr>
		</thead>
		<tbody>
			<form method="post" name="show">
				<c:forEach items="${userone}" var="user">
					<tr align="center">
						<td>${user.username }</td>
						<td>${user.password}</td>
						<td>${user.sex}</td>
						<td>${user.school}</td>
					</tr>
				</c:forEach>
			</form>
		</tbody>
	</table>
	<c:if test="${empty userone}">
		<tr>
			<td>暂无数据</td>
		</tr>
	</c:if> 
</body>
</html>