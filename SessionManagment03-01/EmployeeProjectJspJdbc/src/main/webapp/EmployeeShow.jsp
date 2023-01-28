<%@page import="com.java.EmployeeProjectJspJdbc.Employee"%>
<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDaoImp"%>
<%@page import="com.java.EmployeeProjectJspJdbc.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="table.css">
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3" align="center" class="tablebackground">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<%
			EmployeeDAO dao = new EmployeeDaoImp();
		List<Employee> employees = dao.showEmployeeDao();
		for(Employee employee: employees)
		{
			%>
			<tr>
				<td><%=employee.getEmpId()%></td>
				<td><%=employee.getName() %></td>
				<td><%=employee.getDept() %></td>
				<td><%=employee.getDesg() %></td>
				<td><%=employee.getBasic() %></td>
				<td><a href=UpdateEmployee.jsp?empId=<%=employee.getEmpId() %>  >Update</a></td>
				<td><a href=DeleteEmployee.jsp?empId=<%=employee.getEmpId() %>  >Delete</a></td>
				
			</tr>
			<% 		} %>
		
	</table>
	
	<br/>
	<td><a href=AddEmployee.jsp>Add Employee</a></td>
	

</body>
</html>