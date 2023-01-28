package com.hib.complaint;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;



public class CompIdGenerator implements IdentifierGenerator{
	

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		
		SessionFactory sf=SessionHelper.getconnection();
		Session session =sf.openSession();
		Criteria cr=session.createCriteria(Complaint.class);
		
		List<Complaint> cList=cr.list();
		
		if(cList.size()==0){
			String strfound="C001";
			return strfound;
		}else {
			String strfound=cList.get(cList.size()-1).getComplaintID();

			
			String sub=strfound.substring(1);
			
			int temp=Integer.parseInt(sub);
			
			temp=temp+1;
			
			strfound=String.format("C%03d", temp);
			
			return strfound;
			
		}
		
	}
	
	

}
