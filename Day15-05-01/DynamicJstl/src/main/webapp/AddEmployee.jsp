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
	<form action="AddEmployee.jsp" method="get">
		<center>
		Name
 		<input type="text" name="name"/>
 		Department :
 		<input type="text" name="dept"/>
 		Designation :
 		<input type="text" name="desig"/>
 		Basic :
 		<input type="text" name="basic"/>
 		<input type="submit" value="Insert"/>
		</center>
	</form>
	<c:if test="${param.basic!=null }">
		<jsp:useBean id="employeeDao" class="com.infinite.MethodsClasses.EmployeeDaoImp"/>
		<jsp:useBean id="employee" class="com.infinite.MethodsClasses.Employee"/>
		<jsp:setProperty property="*" name="employee"/>
		<c:out value="${employeeDao.addEmployeeDao(employee)}"></c:out>
	</c:if>

</body>
</html>