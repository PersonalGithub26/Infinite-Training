package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Session Bean implementation class Test
 */
@Stateless
@LocalBean
public class Test implements TestRemote {

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Employ> showEmployBean() throws ClassNotFoundException, SQLException {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		List<Employ> list = cr.list();
		
		return list;
	}

}
