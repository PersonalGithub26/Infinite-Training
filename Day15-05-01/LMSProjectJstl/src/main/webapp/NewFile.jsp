<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Approval</title>
</head>
<body>
<form method="post" action="LeaveApproval.jsp">
	<c:if test="${param.empId != null}">
		<c:set var="empId" value="${param.empId}" />
		<jsp:useBean id="lDao"
			class="com.java.LMSProjectJstl.LevHistoryDaoImp" />
		<c:set var="pendingLeaves" value="${lDao.getPendingLeaves(empId) }" />
		<table border="3" align="center">
			<tr>
				<th>LeaveId</th>
				<th>EmpId</th>
				<th>Leave Toatl Days</th>
				<th>Leave Start Date</th>
				<th>Leave End Date</th>
				<th>Leave Type</th>
				<th>Leave Reason</th>
				<th>Approve/Deny</th>
			</tr>
			<c:forEach var="leave" items="${pendingLeaves}">
				<tr>
					<td>${leave.leaveId}</td>
					<td>${leave.empId}</td>
					<td>${leave.noOfDays}</td>
					<td>${leave.stDate}</td>
					<td>${leave.endDate}</td>
					<td>${leave.leaveTyp}</td>
					<td>${leave.levReason}</td>
					<td>
						
							<input type="hidden" name="leaveId" value="${leave.leaveId}" /> <input
								type="submit" name="action" value="Approve" /> <input
								type="submit" name="action" value="Deny" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>



