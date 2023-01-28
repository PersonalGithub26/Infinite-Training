<%@page import="com.java.EmployeeProjectJspJdbc.Employee"%>
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
	<form method="post" action="AddEmployee.jsp">
		Employee Name :
		<input type="text" name="name"/><br/><br/>
		Department :
		<select name="dept">
			<option value="java">java</option>
			<option value="dotnet">dotnet</option>
			<option value="python">python</option>
			<option value="BigData">Manager</option>
		
		</select><br/><br/>
		Designation :
		<select name="desig">
		<option value="Developer">Developer</option>
		<option value="Tester">Tester</option>
		<option value="Manager">Manager</option>
		<option value="TeamLead">TeamLead</option>
		
		</select><br/><br/>
		Basic : 
		<input type="number" name="basic"/> <br/><br/>
		<input type="submit" value="Insert" />
		
		</form>
		
		<%
			if(request.getParameter("basic")!=null)
			{
				EmployeeDAO dao = new EmployeeDaoImp();
				Employee employee=new Employee();
				employee.setName(request.getParameter("name"));
				employee.setDept(request.getParameter("dept"));
				employee.setDesg(request.getParameter("desig"));
				employee.setBasic(Integer.parseInt(request.getParameter("basic")));
				dao.addEmployeeDao(employee);
		%>
		<jsp:forward page="EmployeeShow.jsp"/>
		<%
			}
		%>
</body>
</html>