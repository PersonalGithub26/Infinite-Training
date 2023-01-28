<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="com.java.LMSProjectJstl.LevHistoryDaoImp"/>

<c:forEach var="leaveid" items="${paramValues.checkedValues}">
<c:out value="${leaveId}"/><br/>
<c:set var="lid" value="${leaveId}"/>
	<c:set var="eid" value="${empId}"/>
	<c:set var="status" value="APPROVED"/>
	<c:set var="mgrc" value="mass aproval..."/>
	<c:out value="${dao.approvDeny(lid,eid,status,mgrc)}"/>
	<c:out value="approved for all"/>
</c:forEach>

</body>
</html>