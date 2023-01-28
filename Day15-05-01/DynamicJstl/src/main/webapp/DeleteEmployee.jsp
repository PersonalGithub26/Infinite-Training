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
	<form action="DeleteEmployee.jsp" method="get">
			<center>
				Employee Id :
				<input type="number" name="empId"/>
				<input type="submit" value="Delete">
			</center>
	</form>
	<c:if test="${param.empId!=null }">
		<c:set var="empId" value="${param.empId}"/>
		<jsp:useBean id="beanDao" class="com.infinite.MethodsClasses.EmployeeDaoImp"/>
		<c:set var="employee" value="${beanDao.deleteEmployeeDao(empId)}"/>
	</c:if>

</body>
</html>