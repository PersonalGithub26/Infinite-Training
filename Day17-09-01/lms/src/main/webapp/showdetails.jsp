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

<c:if test="${param.empId!=null}">
<c:set var="empId" value="${param.empId}"/>
<c:set var="manId" value="${param.manId}"/>

<jsp:useBean id="dao" class="com.java.lms.LmsDaoImpl"/>
<jsp:useBean id="employ" class="com.java.lms.Employee"/>

<c:set var="employ" value="${dao.showOne(empId)}"/>
<c:set var="manager" value="${dao.showOne(manId)}"/>


<c:set var="leaveList" value="${dao.showLeave(empId)}"/>


<table border="3">
<tr>
		<th>Employ No</th>
		<th>Employ Name</th>
		<th>employ mail</th>
		<th>employ mobile</th>
		<th>date of join</th>
		<th>department</th>
		<th>manager id</th>
		<th>leave available</th>
		
	</tr>
	
	

	<tr>
			<td>${employ.empId}</td>
			<td>${employ.empName}</td>
			<td>${employ.empMail}</td>
			<td>${employ.empMobNo}</td>
			<td>${employ.empDtJoin}</td>
			<td>${employ.empDept}</td>
			<td>${employ.empManagerId}</td>
			<td>${employ.empAvailLeaveBal}</td>
	</tr>
	
</table>

<c:if test="${manager!=null}">

<table border="3">
	<tr>
		<th>Manager</th>
		
	</tr>
	<tr>
			<td>${manager.empId}</td>
			<td>${manager.empName}</td>
			<td>${manager.empMail}</td>
			<td>${manager.empMobNo}</td>
			<td>${manager.empDtJoin}</td>
			<td>${manager.empDept}</td>
			<td>${manager.empManagerId}</td>
			<td>${manager.empAvailLeaveBal}</td>
	</tr>

</table>

</c:if>
<c:if test="${manager==null}">
			<c:out value="Manager Not Found.." /> <br/>
	
</c:if>

<%-- <c:if test="${leaveList!=null}">

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


</c:if> --%>


</c:if>
<b><c:out value="applied leaves" /> <br/></b>
<c:out value="---------------------------------------------------" /> <br/>
<jsp:include page="ShowLeaves.jsp"/>
<c:out value="---------------------------------------------------" /> <br/>

<b><c:out value="Pending Leaves of Employees" /> <br/></b>
<c:out value="---------------------------------------------------" /> <br/>
<jsp:include page="PendingLeaves.jsp"/>
</body>
</html>