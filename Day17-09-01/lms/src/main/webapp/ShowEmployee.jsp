<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="com.java.lms.LmsDaoImpl"></jsp:useBean>
<c:set var="employList" value="${dao.showEmployee()}" />


<table border="3">
<tr>
		<th>Employ No</th>
		<th>Employ Name</th>
		<th>employ mail</th>
		<th>employ mobile</th>
		<th>date of join</th>
		<th>department</th>
		<th>manager id</th>
		<th>leave available</th>
		<th>view details</th>
		<th>apply leave</th>
		
		
	</tr>
<c:forEach var="employ" items="${employList}">
		<tr>
			<td>${employ.empId}</td>
			<td>${employ.empName}</td>
			<td>${employ.empMail}</td>
			<td>${employ.empMobNo}</td>
			<td>${employ.empDtJoin}</td>
			<td>${employ.empDept}</td>
			<td>${employ.empManagerId}</td>
			<td>${employ.empAvailLeaveBal}</td>
			<td><a href="showdetails.jsp?empId=${employ.empId}&manId=${employ.empManagerId}" > show details</a></td>
			<td><a href="applyleave.jsp?empId=${employ.empId}" >apply leave</a></td>
			
		</tr>
	</c:forEach>



</table>


</body>
</html>