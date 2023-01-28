<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDaoImp"%>
<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
 	int empid = Integer.parseInt(request.getParameter("empId"));
 	EmployeeDAO dao = new EmployeeDaoImp();
 	dao.deleteEmployeeDao(empid);
 	
 %>
 <jsp:forward page="EmployeeShow.jsp"/>

</body>
</html>