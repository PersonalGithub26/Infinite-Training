<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FullNameJsp.jsp" method="get">
		First Name :
		<input type="text" name="fname"/><br/><br/>\
		Last Name :
		<input type="text" name="lname"><br/><br/>
		<input type="submit" value="show">
	</form>
	<%
		if(request.getParameter("fname")!=null && request.getParameter("lname") !=null)
		{
			String fullName = request.getParameter("fname")+" "+request.getParameter("lname");
			out.println("Full Name is :"+fullName);
			
		}
	%>
</body>
</html>