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
			User Name: <input type="text" name="username" required="required"><br />
			<br /> Password : <input type="password" name="password"
				required="required"><br />
			<br /> <input type="submit" value="Login" />
		</center>

		<%
				if(request.getParameter("username")!=null && request.getParameter("password")!=null)
				{
					String user = request.getParameter("username");
					String pwd = request.getParameter("password");
					if(user.equals("Infinite") && pwd.equals("Infinite"))
					{
						//out.println("Correct.....");
				%>

		<jsp:forward page="Menu.jsp"></jsp:forward>
		<%
					}
					else
					{
						out.println("Incorrect...");
					}
				}
			%>
	</form>

</body>
</html>