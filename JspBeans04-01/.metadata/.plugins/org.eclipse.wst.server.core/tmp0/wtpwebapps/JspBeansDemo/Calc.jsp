<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form actio.n="Calc.jsp" method="get">
		<center>
			First No:
				<input type="number" name="firstNo"/>
			Second number :
				<input type="number" name="secondNo">
				<input type="submit" value="calculate"/>
		</center>
	</form>
	<jsp:useBean id="beanCalc" class="com.java.JspBeansDemo.Calculation"/>
	<jsp:setProperty property="*" name="beanCalc"/>
	Sum is:
	<b>
		<%=beanCalc.sum() %>
	</b>
	Differ is:
	<b>
		<%=beanCalc.diff() %>
	</b>
	Mul is:
	<b>
		<%=beanCalc.mul() %>
	</b>
</body>
</html>