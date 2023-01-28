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
	<c:set var="no" value = "5" />
	<c:if test="${no >=0 }">
	 <c:out value="positive number......"/>
	 </c:if>
	 <c:if test="${no < 0 }">
	 	<c:out value="Negative......."></c:out>
	 </c:if>

</body>
</html>