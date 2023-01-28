package NewAgentRealTime.Agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AddAgentMain {
	
	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Material Status");
		agent.setMaterialStatus(sc.nextInt());
		System.out.println("Enter premium");
		agent.setPremium(sc.nextDouble());
		AgentDAO dao = new AgentDaoImp();
		try {
			System.out.println(dao.addAgentDao(agent));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
