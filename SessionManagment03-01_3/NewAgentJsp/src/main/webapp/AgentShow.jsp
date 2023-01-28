
<%@page import="com.java.NewAgentJsp.Agent"%>
<%@page import="java.util.List"%>
<%@page import="com.java.NewAgentJsp.AgentDaoImp"%>
<%@page import="com.java.NewAgentJsp.AgentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="3" align="center">
		<tr>
			<th>AgentID</th>
			<th>Name</th>
			<th>City</th>
			<th>Gender</th>
			<th>Material Status</th>
			<th>Premium</th>
		</tr>
		<%
			AgentDAO dao = new AgentDaoImp();
			List<Agent> agents=dao.showAgentDao();
			for(Agent agent:agents)
			{
				%>
		<tr>
			<td><%=agent.getAgentId() %></td>
			<td><%=agent.getName() %></td>
			<td><%=agent.getCity() %></td>
			<td><%=agent.getGender() %></td>
			<td><%=agent.getMaterialStatus() %></td>
			<td><%=agent.getPremium() %></td>
		</tr>

		<%
			}
		%>
	</table>
	<br/>
	<td><a href=AddAgent.jsp>Add Agent</a></td>
	
</body>
</html>