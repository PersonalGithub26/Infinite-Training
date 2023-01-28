<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ApproveAll.jsp">
	<jsp:useBean id="Dao" class="com.java.LMSProjectJstl.LevHistoryDaoImp"></jsp:useBean>
	<jsp:useBean id="leave" class="com.java.LMSProjectJstl.levHistory"></jsp:useBean>
	<c:set var="manId" value="${param.maniId }"/>
	<c:set var="empId" value="${param.empId }" />
	<c:set var="levList" value="${Dao.pendingLeaves(empId) }" />
    <table border="3" align="center">
        <tr>
            <th>LeaveId</th>
            <th>EmpId</th>
            <th>Leave Toatl Days</th>
            <th>Manager Comments</th>
            <th>Leave Start Date</th>
            <th>Leave End Date</th>
            <th>Leave Type</th>
            <th>Leave Status</th>
            <th>Leave Reason</th>
            <th>Approve</th>
        </tr>
        <c:forEach var="lev" items="${levList}">
            <tr>
                <td>${lev.leaveId}</td>
                <td>${lev.empId}</td>
                <td>${lev.noOfDays}</td>
                <td>${lev.levMngCmts}</td>
                <td>${lev.stDate}</td>
                <td>${lev.endDate}</td>
                <td>${lev.leaveTyp}</td>
                <td>${lev.status}</td>
                <td>${lev.levReason}</td>
                <td><a href=LeaveApproval.jsp?leaveId= ${lev.leaveId }>Approve/Deney</a></td>
                <td><input type="checkbox" id="ApproveMulti" name="checkedValues" value="${lev.leaveId}"></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <input type="submit" value="Approve" >
    <input type="submit" value="Deny" >
</form>
</body>
</html>
