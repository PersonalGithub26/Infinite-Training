<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDaoImp"%>
<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDAO"%>
<%@page import="com.java.EmployeeProjectJspJdbc.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login.jsp" method="post">
		<center>
			User Name: <input type="text" name="userName"> Password : <input
				type="password" name="password"> <input type="submit"
				value="Login">
		</center>
	</form>
	<%
	String user, pwd;
	user=request.getParameter("userName");
	pwd=request.getParameter("password");
	EmployeeDAO dao = new EmployeeDaoImp();
	int count = dao.authenticate(user, pwd);
	if(user!=null && pwd!=null)
	{
		if(count==1)
		{
	%>
	<jsp:forward page="EmployeeShow.jsp" />
	<%
		}
		else
		{
			out.println("Invalid Credintials.....");
		}
	}
			%>




</body>
</html>