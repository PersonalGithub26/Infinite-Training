<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.java.JspBeansDemo.HelloWorld" />
	Default Message :
	<b> <jsp:getProperty property="greeting" name="bean" /><b /> <jsp:setProperty
			property="greeting" name="bean" value="Good AfterNoon..." /> <br />
	<hr /> Updated Message is : 
	<b> <jsp:getProperty
				property="greeting" name="bean" />
	</b>
</body>
</html>