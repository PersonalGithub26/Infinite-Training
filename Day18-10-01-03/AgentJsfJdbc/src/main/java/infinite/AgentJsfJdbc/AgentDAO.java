package infinite.AgentJsfJdbc;

import java.sql.SQLException;
import java.util.List;


public interface AgentDAO {
	
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
	String searchAgentDao(int AgentId) throws ClassNotFoundException, SQLException;
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException;
	public String deleteAgent(int agentId) throws ClassNotFoundException, SQLException;

	

}
