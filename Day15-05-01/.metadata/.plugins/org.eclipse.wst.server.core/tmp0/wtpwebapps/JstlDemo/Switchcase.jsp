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
	<form action="Switchcase.jsp" method="get">
	<center>
		Student no :
		<input type="number" name="sno"/></br>
		<input type="submit" value="show"/> 
	</center>
	</form>
		<c:if test="${parm.sno!= null }">
		<c:set var="sno" value="${parm.sno }"/>
		<c:choose>
			<c:when test="${sno==1 }">
				<c:out value="Im chandu"/>
			</c:when>
			
			<c:when test="${sno==2 }">
				<c:out value="Im Srinivas"/>
			</c:when>
			
			<c:when test="${sno==3 }">
				<c:out value="Im Srikanth"/>
			</c:when>
			
			<c:when test="${sno==4 }">
				<c:out value="Im Ajay"/>
			</c:when>
			
			<c:otherwise>
				<c:out value="Invalid number...."></c:out>
			</c:otherwise>
			
		</c:choose>
		</c:if>
	
	
			
	

</body>
</html>