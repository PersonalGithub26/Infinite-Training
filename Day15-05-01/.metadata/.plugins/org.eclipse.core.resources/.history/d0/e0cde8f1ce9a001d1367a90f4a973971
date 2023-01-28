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
<c:set var="eid" value="${param.empId}"/>
<form action="LeaveApproval.jsp">
	<center>
		Leave Id : 
		<input type=number name="leaveId" value="${param.leaveId}" /> <br/>
		<%-- Employ Id : 
		<input type="number" name="empId" value="${eid}" /> <br/> --%>
		Approve or Deny:
		<select name="status">
			<option value="APPROVED">APPROVE</option>
			<option value="DENIED">DENY</option>
		</select> <br/>
		Manager Comments : 
		<input type="text" name="managerComments" /> <br/><Br/>
		<input type="submit" value="submit" />
	</center>

</form>

<c:if test="${param.leaveId!=null}">
<jsp:useBean id="dao" class="com.java.LMSProjectJstl.LevHistoryDaoImp"/>
<c:set var="Lid" value="${param.leaveId}"/>
<c:set var="eid" value="${param.empId}"/>
<c:set var="status" value="${param.status}"/>
<c:set var="mgrc" value="${param.levMngCmts}"/>
			<br/>

<c:out value="${dao.approvDeny(Lid,eid,status,mgrc)}"/>
</c:if>






</body>
</html>