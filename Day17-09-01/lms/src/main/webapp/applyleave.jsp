<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	    
	<form action="applyleave.jsp">
		         
		<table border="3" align="center">

			<tr>
				<th colspan="2">Leave Application Form</th>
			</tr>
			<tr>

				<th>EmpID</th>
				<td><input type="number"   readonly="readonly" name="empId"
					value="${param.empId}" /></td>            
			</tr>
			<tr>
				<th>Leave Start Date</th>
				<td><input type="date" name="leaveStart" /></td>            
			</tr>
			<tr>
				                
				<th>Leave End Date</th>                
				<td><input type="date" name="leaveEnd" /></td>            
			</tr>
			            
			<tr>
				                
				<th>Leave Type</th>                
				<td><select name="leaveType"><option value="EL">EL</option>
						<option value="PL">PL</option>
						<option value="ML">ML</option>                
				</select></td>            
			</tr>
			<!-- <tr>                 <th>No of Days</th>                 <td><input type="number" readonly="readonly" name="leaveNoOfDays" />                 </td>              </tr> -->
			                         
			<tr>
				                
				<th>Leave Reason</th>                
				<td><input type="text" name="leaveReason" /></td>            
			</tr>
			        
		</table>
		<input type="submit" value="apply">    
	</form>
	        
	<c:set var="lsd" value="${param.leaveStart}" />
	<c:set var="led" value="${param.leaveEnd}" /><jsp:useBean id="emp"
		class="com.java.lms.Employee" /><jsp:useBean id="dao"
		class="com.java.lms.LmsDaoImpl" /><jsp:useBean id="lv"
		class="com.java.lms.LeaveHistory"></jsp:useBean><jsp:setProperty
		property="empId" name="lv" value="${param.empId}" /><jsp:setProperty
		property="leaveStartDate" name="lv" value="${dao.convertDate(lsd)}" /><jsp:setProperty
		property="leaveEndDate" name="lv" value="${dao.convertDate(led)}" /><jsp:setProperty
		property="leaveType" name="lv" value="${param.leaveType}" /><jsp:setProperty
		property="leaveReason" name="lv" value="${param.leaveReason}" /><c:out
		value="${dao.leaveApply(lv)}" />
	       
</body>
</html>