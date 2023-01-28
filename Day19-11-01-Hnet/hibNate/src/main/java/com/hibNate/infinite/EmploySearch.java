package com.hibNate.infinite;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class EmploySearch {
	
	public static void main(String[] args) {
		
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ no.");
		empno= sc.nextInt();
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query= session.createQuery("From Employ where empno="+empno);
		List<Employ> list = query.list();
		if(list.size()==0)
		{
			System.out.println("Record not found...");
		}
		else
		{
			Employ employ = list.get(0);
			System.out.println(employ);
		}
		
	}

}
