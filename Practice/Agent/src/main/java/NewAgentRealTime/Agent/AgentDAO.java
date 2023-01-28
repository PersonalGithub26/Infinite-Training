package NewAgentRealTime.Agent;

import java.sql.SQLException;

public interface AgentDAO {
	
	String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;

}
