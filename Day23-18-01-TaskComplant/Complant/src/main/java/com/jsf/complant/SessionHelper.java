package com.jsf.complant;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHelper {
	
	public static SessionFactory getconnection()
	{
		return new Configuration().configure().buildSessionFactory();
	}

}
