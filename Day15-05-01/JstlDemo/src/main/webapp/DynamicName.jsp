<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form action="DynamicName.jsp" method="get">
 	<center>
 		Strudent name :
 		<input type="text" name="sname">
 		<input type="submit" value="show"> 
 	
 	</center>
 </form>
 	<c:if test="${param.sname!=null}">
 		<c:set var="sname" value="${param.sname}"/>
 		 Name is :
 		 <b>
 		 	<c:out value="${sname }"></c:out>
 		 </b>
 	</c:if>

</body>
</html>