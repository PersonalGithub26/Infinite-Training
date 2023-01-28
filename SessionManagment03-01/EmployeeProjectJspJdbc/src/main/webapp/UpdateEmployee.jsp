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
	<%
	int empid = Integer.parseInt(request.getParameter("empId"));
	EmployeeDAO dao = new EmployeeDaoImp();
	Employee EmployeeFound = dao.searchEmployeeDao(empid);
	%>
	<form action="UpdateEmployee.jsp" method="post">
		Employee Id: <input type="number" name="empId"
			value=<%=EmployeeFound.getEmpId()%> readonly="readonly" /> <br/><br/>
		 Employee Name : <input type="text" name="name"
			value='<%=EmployeeFound.getName()%>' /><br/><br/>
		 Department : <input type="text" name="dept"
			value=<%=EmployeeFound.getDept()%> /><br/><br/>
		 Designation : <input type="text" name="desig"
			value=<%=EmployeeFound.getDesg()%> /><br/><br/>
			Basic : <input type="number" name="basic" value=<%=EmployeeFound.getBasic() %>/>
			
		<br /> <input type="submit" value="Update">
	</form>
	<%
		if(request.getParameter("empId")!=null && request.getParameter("basic")!=null)
		{
			Employee employee = new Employee();
			employee.setEmpId(Integer.parseInt(request.getParameter("empId")));
			employee.setName(request.getParameter("name"));
			employee.setDept(request.getParameter("dept"));
			employee.setDesg(request.getParameter("desig"));
			employee.setBasic(Integer.parseInt(request.getParameter("basic")));
			dao.updateEmployee(employee);
		
	%>
	<jsp:forward page="EmployeeShow.jsp"/>
	<%	} %>
	

</body>
</html>