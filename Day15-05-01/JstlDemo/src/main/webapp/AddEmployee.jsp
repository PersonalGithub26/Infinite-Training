<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddEmployee.jsp" method="get">
	<center>
		
 		Name
 		<input type="text" name="name"/>
 		Department :
 		<input type="text" name="dept"/>
 		Designation :
 		<input type="text" name="desig"/>
 		Basic :
 		<input type="text" name="basic"/>
 		<input type="submit" value="Insert"/>
	</center>
</form>
<c:if test="${param.basic!=null }">
	<sql:setDataSource var="conn"
				driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost:3306/infinite"
				user="root" password="india@123" />
					<sql:update var="empUpdate" dataSource="${conn}">
		Insert into Employ(name,dept,desig,basic) values(?,?,?,?)
			<sql:param value="${param.name }"/>
			<sql:param value="${param.dept }"/>
			<sql:param value="${param.desig }"/>
			<sql:param value="${param.basic }"/>
	</sql:update>
	
				
</c:if>

</body>
</html>