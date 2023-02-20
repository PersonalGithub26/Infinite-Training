package com.java.ejb;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionHelper {
	public static SessionFactory getConnection() {
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}

	//	Test/remote - EJB3.x Default Remote Business Interface
	//	Test/remote-com.java.ejb.TestRemote - EJB3.x Remote Business Interface

}
