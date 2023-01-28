package com.java.NewAgentJsp;

import java.sql.SQLException;
import java.util.List;

public class AgentShowAllMain {

	public static void main(String[] args) {

		AgentDAO dao = new AgentDaoImp();
			List<Agent> agentList;
			
			try {
				agentList = dao.showAgentDao();
				for (Agent agent : agentList) {
					System.out.println(agent);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		
	}

}

