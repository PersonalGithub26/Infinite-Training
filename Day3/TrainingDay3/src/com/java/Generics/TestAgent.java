package com.java.Generics;

public class TestAgent {
	
	public static void main(String[] args) {
		
		Agent agent = new Agent();
		agent.setAgentId(1);
		agent.setAgentname("Tina");
		agent.setCity("knp");
		
		System.out.println(agent.getAgentId());
		System.out.println(agent.getAgentname());
		System.out.println(agent.getCity());
	}

}
