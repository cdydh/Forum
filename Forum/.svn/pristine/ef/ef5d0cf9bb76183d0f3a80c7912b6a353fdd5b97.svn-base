<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>EmpList</title>
<link
	href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container">

		<h2>Emp List</h2>
		<table class="table table-striped">
			<thead>
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Comm</th>
				<th>HireDate</th>
				<th>Enabled</th>
			</thead>
			<tbody>
				<c:forEach items="${emps}" var="emp" >
					<tr>
						<td>${emp.empNo }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.sal }</td>
						<td>${emp.comm }</td>
						<td>${emp.hireDate }</td>
						<td>${emp.enabled }</td>
					</tr>
				</c:forEach>
				<c:if test="${empty emps }">
					<tr>
						<td colspan="7">暂无数据</td>
					</tr>
				</c:if>
			</tbody>
			</div>
		</table>
	</div>
</body>

</html>