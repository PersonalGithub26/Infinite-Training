package com.hibNate.infinite;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class UpdateEmploy {

	public static void main(String[] args) {
		
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter employ no :");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Name :");
		employ.setName(sc.next());
		System.out.println("Enter Department :");
		employ.setDept(sc.next());
		System.out.println("Enter Designantion :");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextInt());
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.update(employ);
		t.commit();
		System.out.println("Record updated...");

	}

}
