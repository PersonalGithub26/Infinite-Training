package NewAgentRealTime.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AgentDaoImp implements AgentDAO{

	Connection helper;
	PreparedStatement pst;

	@Override
	public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {


		helper = ConnectionHelper.getConnection();

		String cmd = "insert into Agent(Name,City,Gender,MaritalStatus,Premium) values(?,?,?,?,?)";
		pst=helper.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender().toString());
		pst.setInt(4, agent.getMaterialStatus());
		pst.setDouble(5, agent.getPremium());
		pst.executeUpdate();

		return "Agent Added Successfully";
	}



}
