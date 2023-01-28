<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="conn"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/infinite"
	user="root" password="india@123"
/>
<sql:query var="employeeQuery" dataSource="${conn}">
	select * from Employ
</sql:query>
<table border="3">
	<tr>
		<th>EmpID</th>
		<th>Name</th>
		<th>Department</th>
		<th>Designation</th>
		<th>basic</th>
	</tr>
	<c:forEach var="employee" items="${employeeQuery.rows}">
		<tr>
			<td>${employee.empno}</td>
			<td>${employee.name}</td>
			<td>${employee.dept}</td>
			<td>${employee.desig}</td>
			<td>${employee.basic}</td>
			
			
		</tr>
	</c:forEach>
</table>
	
</body>
</html>