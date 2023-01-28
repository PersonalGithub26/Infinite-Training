package com.hibNate.infinite;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmployShow {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session =sf.openSession(); 
		Query query = session.createQuery("from Employ");
		List<Employ> list = query.list();
		for (Employ employ : list) {
			System.out.println(employ);
		}
				
	}

}
