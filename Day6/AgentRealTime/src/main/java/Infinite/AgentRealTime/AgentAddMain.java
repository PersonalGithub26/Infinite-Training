package Infinite.AgentRealTime;

import java.sql.SQLException;
import java.util.Scanner;



public class AgentAddMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		System.out.println("Enter agent name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter MaterialStatus");
		agent.setMaterialStatus(sc.nextInt());
		System.out.println("Enter Premium");
		agent.setPremium(sc.nextDouble());
		AgentDAO dao= new AgentDaoImp();
		
		try {
			System.out.println(dao.addAgentDao(agent));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
