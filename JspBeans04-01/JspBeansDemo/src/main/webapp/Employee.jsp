<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Employee.jsp" method="get">
		<center>
			EmpId :
				<input type="number" name="empId"/><br/><br/>
			Employee Name :
				<input type="text" name="name"><br/><br/>
			Employee Department :
				<input type="text" name="dept"/><br/><br/>
			Employee Designation :
				<input type="text" name="desig"/><br/><br/>
			Employee Basic :
				<input type="number" name="basic"/><br/><br/>
				<input type="submit" value="Show">
		</center>
		
	</form>
	<jsp:useBean id="beanEmployee" class="com.java.JspBeansDemo.Employee"/>
	<jsp:setProperty property="*" name="beanEmployee"/>
	Employee Id:
	<jsp:getProperty property="empId" name="beanEmployee"/>
	Employee Name:
	<jsp:getProperty property="name" name="beanEmployee"/>
	Department :
	<jsp:getProperty property="dept" name="beanEmployee"/>
	Designation :
	<jsp:getProperty property="desig" name="beanEmployee"/>
	Basic :
	<jsp:getProperty property="basic" name="beanEmployee"/>

</body>
</html>