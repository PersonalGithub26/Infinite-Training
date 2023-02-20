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
<jsp:useBean id="dao" class="com.java.lms.LmsDaoImpl"/>
<jsp:useBean id="employ" class="com.java.lms.Employee"/>
<c:set var="empId" value="${param.empId}"/>


<c:set var="leaveList" value="${dao.showLeave(empId)}"/>

<c:if test="${leaveList!=null}">

<table border="3">
<tr>
		<th>Leave id</th>
		<th>num of days</th>
		<th>manager comments</th>
		<th>emp id</th>
		<th>start date</th>
		<th>end date</th>
		<th>leave type</th>
		<th>leave status</th>
		<th>leave reason</th>
		
	</tr>
	
	<c:forEach var="leave" items="${leaveList}">
		<tr>
			<td>${leave.leaveId}</td>
			<td>${leave.leaveNoOfDays}</td>
			<td>${leave.leaveManagerComments}</td>
			<td>${leave.empId}</td>
			<td>${leave.leaveStartDate}</td>
			<td>${leave.leaveEndDate}</td>
			<td>${leave.leaveType}</td>
			<td>${leave.leaveStatus}</td>
			<td>${leave.leaveReason}</td>
			
		</tr>
	</c:forEach>
	
</table>
</c:if>

<c:if test="${leaveList==null}">

<c:out value="No Applied Leaves..." /> <br/>

</c:if>








</body>
</html>