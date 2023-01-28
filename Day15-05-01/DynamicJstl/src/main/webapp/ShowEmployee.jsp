<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="employeeDao"
		class="com.infinite.MethodsClasses.EmployeeDaoImp" />
	<c:set var="employeeList" value="${employeeDao.showEmployeeDao() }" />
	<table border="3" align="center">
		<tr>
			<th>EmpID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>basic</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
			
				<td>${employee.empId}</td>
				<td>${employee.name}</td>
				<td>${employee.dept}</td>
				<td>${employee.desg}</td>
				<td>${employee.basic}</td>


			</tr>

		</c:forEach>
		</table>
</body>
</html>