package infinite.AgentJsfJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "agentDao")
@SessionScoped

public class AgentDaoImp implements AgentDAO{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next())
		{
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentID"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaterialStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			agentList.add(agent);
		}
		connection.close();
		pst.close();
		return agentList;
	}

	@Override
	public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Agent(Name,city,Gender,MaritalStatus,premium) values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender().toString());
		pst.setInt(4, agent.getMaterialStatus());
		pst.setDouble(5, agent.getPremium());
		pst.executeUpdate();
		connection.close();
		pst.close();
		
		return "Agent Record inserted....";
		
	}

	@Override
	public String searchAgentDao(int AgentId) throws ClassNotFoundException, SQLException {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from  agent where AgentID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, AgentId);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		if(rs.next())
		{
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentID"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaterialStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			
			 sessionMap.put("AgentEdit", agent);
			
		}
		connection.close();
		pst.close();
		return "UpdateAgent.xhtml?faces-redirect=true";
		
	}

	@Override
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		String cmd = "update agent set Name=?, City=?, GENDER=?, "
				+ " GENDER =?, Premium=? where AgentID=?";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender().toString());
		pst.setInt(4, agent.getMaterialStatus());
		pst.setDouble(5, agent.getPremium());
		pst.setInt(6, agent.getAgentId());
		pst.executeUpdate();
//		return "Agent Record Updated...";
	return "AgentShow.xhtml?faces-redirect=true";
		
	}

	@Override
	public String deleteAgent(int agentId) throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "delete from agent where AgentID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		pst.executeUpdate();
		return "AgentShow.xhtml?faces-redirect=true";
	}
			}
	


