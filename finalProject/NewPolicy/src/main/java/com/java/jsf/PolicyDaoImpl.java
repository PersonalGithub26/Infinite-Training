package com.java.jsf;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "pDao")
@SessionScoped
public class PolicyDaoImpl implements PolicyDao {

	int n1=0;
	 int n2=4;

	@Override
	public String addPolicy(Policy policy) {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		
		policy.setPid(generatePolicyID());
		policy.setStatus("ACTIVE");
		policy.setBuydate(new Date());
	
		
		
		
		
		if(
			policy.getPremium()==100000	
		){
			Date regDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(regDate);
			calendar.add(Calendar.YEAR,1);
			System.out.println("Added Date  " +calendar);
			policy.setActivedate(calendar.getTime());
			Date newDate=calendar.getTime();
			calendar.setTime(newDate);
			calendar.add(Calendar.YEAR,2);
			policy.setEnddate(calendar.getTime());
		}
		if (
			policy.getPremium()==300000
					){
			Date regDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(regDate);
			calendar.add(Calendar.MONTH,8);
			System.out.println("Added Date  " +calendar);
			policy.setActivedate(calendar.getTime());
			Date newDate=calendar.getTime();
			calendar.setTime(newDate);
			calendar.add(Calendar.YEAR,1);
			policy.setEnddate(calendar.getTime());
				
			}
		
			if (policy.getPremium()==500000){
				Date regDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(regDate);
				calendar.add(Calendar.MONTH,6);
				System.out.println("Added Date  " +calendar);
				policy.setActivedate(calendar.getTime());
				Date newDate=calendar.getTime();
				calendar.setTime(newDate);
				calendar.add(Calendar.YEAR,2);
				policy.setEnddate(calendar.getTime());
				
			}
		

		
		Transaction trans = session.beginTransaction();
		session.save(policy);
			trans.commit();
		 
		return "ShowPolicy.xhtml?faces-redirect=true";
	}

	private String generatePolicyID() {
		
		int pid=0;
		 SessionFactory sf = SessionHelper.getConnection();
		 Session session = sf.openSession();
		 Criteria cr=session.createCriteria(Policy.class);
		 cr.setProjection(Projections.max("pid"));
		 String str=(String)cr.uniqueResult();
		 if(str==null)
		 {
			 str="p00";
		 }
		 String sub = str.substring(1);
		 pid = Integer.parseInt(sub);
		 pid++;
		 return String.format("P%03d", pid);
		
		
		
//		SessionFactory sf = SessionHelper.getConnection();
//		Session session = sf.openSession();
//		Criteria criteria = session.createCriteria(Policy.class).setProjection(Projections.max("pid"));
//		String str = (String) criteria.uniqueResult();
//		String sub = str.substring(1);
//		int tempId = Integer.parseInt(sub);
//		tempId++;
//		return String.format("P%03d", tempId);
	}

	@Override
	public List<Policy> showPolicy() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
//		cr.setFirstResult(n1);
//		cr.setMaxResults(n2);
		List<Policy> list = cr.list();
		return list;
	}
	
	public String next()
	{
	
		
		n1+=4;
		n2=4;
		return "ShowPolicy.xhtml?faces-redirect=true";
		
	}
	
	public String prev()
	{
		
		n1-=4;
		n2-=4;
		return "ShowPolicy.xhtml?faces-redirect=true";
	}


	@Override
	public String deletePolicyDao(String pid) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria cr = session.createCriteria(Policy.class);
		cr.add(Restrictions.eq("pid",pid));
		List<Policy> pList = cr.list();
		if (pList.size() == 0) {
			System.out.println("Record not found..");
		} else {
			Policy policy = pList.get(0);
			Transaction t = session.beginTransaction();
			session.delete(policy);
			t.commit();
			System.out.println("record deleted");
		}
		return "ShowPolicy.xhtml?faces-redirect=true";
	}
	
	private String insuranceNames;

	public String getInsuranceNames() {
		return insuranceNames;
	}

	public void setInsuranceNames(String insuranceNames) {
		this.insuranceNames = insuranceNames;
	}
	
	public void onNameChanged(ValueChangeEvent e)
	{
		this.insuranceNames=e.getNewValue().toString();
	}
	
	
	public List<Policy> getPolicyNames()
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		cr.setProjection(Projections.distinct(Projections.property("pname")));
		List<Policy> list = cr.list();
		session.close();
		return list;
	}
	
	public List<String> getAllPolicyNames() {
		SessionFactory sf = SessionHelper.getConnection();
	      Session session = sf.openSession();
	      Criteria cr = session.createCriteria(Policy.class);
	      cr.setProjection(Projections.property("pname"));
	      List<String> policyNames = cr.list();
	      return policyNames;

	
	}
	
	


}
