package com.infinite.Agent;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class UpdateAgent {
	
public static void main(String[] args) {
		
		Agent agent= new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter Agent id :");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter Name :");
		agent.setName(sc.next());
		System.out.println("Enter City :");
		agent.setCity(sc.next());
		System.out.println("Enter Gender :");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter MareterialStatus");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter premium");
		agent.setPremium(sc.nextInt());
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.update(agent);
		t.commit();
		System.out.println("Record updated...");
}


}
