package com.infinite.Agent;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.AnnotationConfiguration;

public class SearchAgent {
	
public static void main(String[] args) {
		
		int agentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent no.");
		agentId= sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query= session.createQuery("From Agent where AgentId="+agentId);
		List<Agent> list = query.list();
		if(list.size()==0)
		{
			System.out.println("Record not found...");
		}
		else
		{
			Agent agent = list.get(0);
			System.out.println(agent);
		}
}

}
