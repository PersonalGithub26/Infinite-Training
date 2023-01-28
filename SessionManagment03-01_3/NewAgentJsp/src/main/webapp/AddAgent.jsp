<%@page import="com.java.NewAgentJsp.Gender"%>
<%@page import="org.glassfish.jersey.client.RequestEntityProcessing"%>
<%@page import="com.java.NewAgentJsp.Agent"%>
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
<form action="AddAgent.jsp" method="post">
	Agent Name:
	<input type="text" name="aname"/><br/><br/>
	City :
	<input type="text" name="city"><br/><br/>
	Gender :
	 <select name="gender">
	<option value="MALE">MALE</option>
	<option value="FEMALE">FEMALE</option>
	
	
	</select><br/><br/>
	MaritalStatus :
	<select name="mstatus">
		<option	value="0">0</option>
		<option	value="1">1</option>
	</select><br/><br/>
	
	 <input type="number" name="premium">
	<input type="submit" value="Insert"> 
	
	
</form>
	<%
		if(request.getParameter("premium")!=null)
		{
			
			AgentDAO dao = new AgentDaoImp();
			Agent agent= new Agent();
			agent.setName(request.getParameter("aname"));
			agent.setCity(request.getParameter("city"));
			agent.setGender(Gender.valueOf(request.getParameter("gender")));
			agent.setMaterialStatus(Integer.parseInt(request.getParameter("mstatus")));
			agent.setPremium(Integer.parseInt(request.getParameter("premium")));
			dao.addAgentDao(agent);
		%>
		<jsp:forward page="AgentShow.jsp"/>
		<%	
			
		}
	%>

</body>
</html>