package com.java.NewAgentJsp;

import java.sql.SQLException;
import java.util.List;


public interface AgentDAO {
	
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
	Agent searchAgentDao(int AgentId) throws ClassNotFoundException, SQLException;

	

}
