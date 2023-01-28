<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Student.jsp" method="get">
		<center>
			Student Name :
			<input type="text" name="sname">
			<input type="submit" value="show">
		</center>
		
	</form>
	<%
		if(request.getParameter("sname")!=null)
		{
			String sname = request.getParameter("sname");
		
	%>
	<jsp:useBean id="beanStudent" class="com.java.JspBeansDemo.Student"/>
	<jsp:setProperty property="sname" name="beanStudent"/>
	Student Name is :
	<jsp:getProperty property="sname" name="beanStudent"/>
	<%} %>
</body>
</html>