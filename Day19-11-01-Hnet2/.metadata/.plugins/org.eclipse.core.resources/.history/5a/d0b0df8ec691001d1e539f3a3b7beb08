package com.infinite.Agent;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AgentShow {

	
public static void main(String[] args) {
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session =sf.openSession(); 
		org.hibernate.Query query = session.createQuery("from Agent");
		List<Agent> list = query.list();
		for (Agent agent : list) {
			System.out.println(agent);
		}
				
	}
}
