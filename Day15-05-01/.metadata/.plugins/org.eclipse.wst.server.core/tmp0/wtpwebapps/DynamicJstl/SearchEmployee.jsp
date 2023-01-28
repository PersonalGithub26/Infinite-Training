<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SearchEmployee.jsp" method="get">
			<center>
				Employee Id :
				<input type="number" name="empId"/>
				<input type="submit" value="Search">
			</center>
	</form>
	<c:if test="${param.empId!=null }">
		<c:set var="empId" value="${param.empId }"/>
		<jsp:useBean id="beanDao" class="com.infinite.MethodsClasses.EmployeeDaoImp"/>
		<c:set var="employee" value="${beanDao.searchEmployeeDao(empId) }"/>
		<c:if test="${employee!=null }">
			Employee Id :
			 <c:out value="${employee.empId }"/><br/>
			Employee Name 
			 <c:out value="${employee.name }"/><br/>
			Department
			 <c:out value="${employee.dept }"/><br/>
			Designation
			 <c:out value="${employee.desg }"/><br/>
			Basic 
			 <c:out value="${employee.basic }"/><br/>
		</c:if>
	</c:if>
</body>
</html>