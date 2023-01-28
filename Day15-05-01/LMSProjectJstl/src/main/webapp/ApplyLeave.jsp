<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ApplyLeave.jsp">

		<table border="3" align="center">

			<tr>
				<th colspan="2">Leave Application Form</th>
			</tr>
			<tr>
				<th>EmpID</th>
				<td><input type="number" readonly="readonly" name="eId"
					value="${param.empId}" /></td>
			</tr>
			<tr>
				<th>Leave Start Date</th>
				<td><input type="date" name="stDate" /></td>
			</tr>
			<tr>
				<th>Leave End Date</th>
				<td><input type="date" name="endDate" /></td>
			</tr>
			<tr>
				<th>Leave Type</th>
				<td><select name="leaveTyp">
						<option value="EL">EL</option>
				</select></td>
			</tr>
			<tr>
				<th>Leave Status</th>
				<td><select name="status">
						<option value="PENDING">PENDING</option>
				</select></td>
			</tr>
			
			<tr>
				<th>Leave Reason</th>
				<td><input type="text" name="levReason" /></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="Apply Leave" />
				</th>
			</tr>
		</table>

	</form>
	<c:if test="${param.levReason!=null}">
	<c:set var="lsd" value="${param.stDate}" />
	<c:set var="led" value="${param.endDate}" />
	<jsp:useBean id="emp" class="com.java.LMSProjectJstl.Employ" />
	<jsp:useBean id="dao" class="com.java.LMSProjectJstl.LevHistoryDaoImp" />
	<jsp:useBean id="lv" class="com.java.LMSProjectJstl.levHistory"></jsp:useBean>

	<jsp:setProperty property="empId" name="lv" value="${param.eId}" />
	<jsp:setProperty property="stDate" name="lv"
		value="${dao.convertDate(lsd)}" />
	<jsp:setProperty property="endDate" name="lv"
		value="${dao.convertDate(led)}" />
	<jsp:setProperty property="leaveTyp" name="lv"
		value="${param.leaveTyp}" />
		<jsp:setProperty property="status" name="lv"
		value="${param.status }" />
	<jsp:setProperty property="levReason" name="lv"
		value="${param.levReason}" />

	<%-- <c:out value="${lv}"></c:out> --%>

	<c:out value="${dao.ApplyLeave(lv)}"></c:out>

</c:if>



</body>
</html>