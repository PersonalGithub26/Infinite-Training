package com.java.project;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import com.java.hms.Company;
import com.java.hms.Insurance;
import com.java.hms.Premium;
import com.java.hms.RecInsurance;
import com.java.hms.SessionHelper;

import com.java.infinite.Recipient.SignUpRecipient;


@ManagedBean(name = "pDao")
@ViewScoped
public class ProviderDAOImpl implements ProviderDAO {
	double pre1;

	/*
	 * public String verify(String username) { SessionFactory sf =
	 * SessionHelper.getConnection(); Session session = sf.openSession();
	 * Criteria cr = session.createCriteria(Provider.class);
	 * cr.add(Restrictions.eq("username", username)); Long count =
	 * (Long)cr.uniqueResult(); if(count == 0) { return username; }
	 * 
	 * 
	 * return null; }
	 */

	// AUTO GENERATES PROVIDER'S ID
	public double getPre1() {
		return pre1;
	}

	public void setPre1(double pre1) {
		this.pre1 = pre1;
	}
String planName;
String companyName;


	public String getPlanName() {
	return planName;
}

public void setPlanName(String planName) {
	this.planName = planName;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

	private String generateProviderID() {
		SessionFactory sfactory = SessionHelper.getConnection();
		Session session = sfactory.openSession();
		Criteria criteria = session.createCriteria(Provider.class).setProjection(Projections.max("providerId"));
		String str = (String) criteria.uniqueResult();
		if (str == null) {
			return "P001";

		}
		String order = str.substring(1);
		int pId = Integer.parseInt(order);
		pId++;
		return String.format("P%03d", pId);
	}

	@Override
	public String addProvider(Provider provider) {

		String ans = EntryptPassword.getCode(provider.getAnswer());
		String ans2 = EntryptPassword.getCode(provider.getAnswer2());
		String pid = generateProviderID();
		provider.setProviderId(pid);
		provider.setAnswer(ans);
		provider.setAnswer2(ans2);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Provider.class);

		Transaction t = session.beginTransaction();
		session.save(provider);
		t.commit();
		return Searchstrings.getShowXhtml();
	}

	@Override
	public List<Provider> showProvider() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Provider.class);
		List<Provider> pList = cr.list();
		return pList;
	}

	/**
	 * 
	 * @param signupresp
	 * @return
	 * 
	 * 		returns the policy Buying page after matching the Username and
	 *         email in the Provider Table
	 */
	@Override
	public String validateMe(Provider provider) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Provider.class);
		cr.add(Restrictions.eq(Searchstrings.getUserName(), provider.getUsername()));
		cr.add(Restrictions.eq(Searchstrings.getProviderEmail(), provider.getProviderEmailId()));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		if (count == 1) {
			Provider p = searchByProviderName(provider.getUsername(), provider.getProviderEmailId());
			// System.out.println(c);
			// sessionMap.put("providerId", p.getProviderId());
			sessionMap.put(Searchstrings.getProviderinfo1(), p);

			Searchstrings.getLogger().info("Login Success");
			return Searchstrings.getBuyorrenew1Xhtml();

		} else {
			sessionMap.put(Searchstrings.getErrorr(), Searchstrings.getErrorMsg());
			Searchstrings.getLogger().info("Login Failed..!!!");

			return Searchstrings.getProviderLoginXhtml();
		}
	}

	/**
	 * 
	 * @param userName
	 * @param providerEmailId
	 * @return Takes the userName and email as input and Goes into provider
	 *         table matches these 2 parameters and returns a Unique row object
	 */

	@Override
	public Provider searchByProviderName(String username, String providerEmailId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Provider.class);
		cr.add(Restrictions.eq(Searchstrings.getUserName(), username));
		cr.add(Restrictions.eq(Searchstrings.getProviderEmail(), providerEmailId));

		Provider provider = (Provider) cr.uniqueResult();
		return provider;
	}

	/**
	 * 
	 * @param dateOfBirth
	 * @return Takes the Date as Input and Calculates age with the Corresponding
	 *         Date and returns it
	 * 
	 */

	public int calculateAge1(Date dateOfBirth) {
		Calendar today = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(dateOfBirth);
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		return age;
	}

	/**
	 * 
	 * @param providerId
	 * @param planId
	 * @param cId
	 * @param age
	 * @return Calculates Premium and Coverage Based on age of Provider and
	 *         returns the Details of Selected Policy
	 */

	@Override
	public String Calculatepremium(String providerId, String planId, String cId, int age) {
		try {

			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Transaction trans = session.beginTransaction();

			RecInsurance rec = new RecInsurance();

			Criteria cr = session.createCriteria(Insurance.class);
			cr.add(Restrictions.eq(Searchstrings.getPlanid(), planId));

			Insurance ins = (Insurance) cr.uniqueResult();
			planName=ins.getPlanName();
			System.out.println("Plan Name is" +planName);
			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("planName", planName);
			Searchstrings.getLogger().info("Plan Name is "+planName);
			String CID = ins.getcId();
			Company com = new Company();
			Criteria cr6 = session.createCriteria(Company.class);
			cr6.add(Restrictions.eq("cId", CID));
			Projection projection6 = Projections.property("companyName");
			cr6.setProjection(projection6);
			companyName=(String) cr6.uniqueResult();
			System.out.println("Company Name is"+companyName);
			Map<String, Object> sessionMap1 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap1.put("Comm", companyName);
		
			
			
			if (age <= 18) {

				// rec.setCoverageapplicable(ins.getCoverage_bel_18());
				double covfor18 = ins.getCoverage_bel_18();
				Searchstrings.getLogger().info("Coverage Applicable is:" + covfor18);

				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getCov1(), covfor18);
			}
			if (age > 18 && age < 60) {
				// rec.setCoverageapplicable(ins.getCoverage_18to60());
				double covfor18to60 = ins.getCoverage_18to60();
				Searchstrings.getLogger().info("Coverage Applicable is:" + covfor18to60);

				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getCov1(), covfor18to60);
			}
			if (age >= 60) {

				double covfor60 = ins.getCoverage_above60();
				Searchstrings.logger.info("Coverage Applicable is:" + covfor60);

				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getCov1(), covfor60);
			}
			Projection projection = Projections.property(Searchstrings.getPrem());
			cr.setProjection(projection);

			Premium premiumId1 = (Premium) cr.uniqueResult();
			Searchstrings.getLogger().info("Premium ID fetched  is:" + premiumId1);

			if (age <= 18) {

				Criteria cr1 = session.createCriteria(Premium.class);
				Searchstrings.getLogger().info("Premium Id is:"+premiumId1);
				
				cr1.add(Restrictions.eq(Searchstrings.getPremiumid(), premiumId1.getPremiumId()));
				Searchstrings.getLogger().info("list" + cr1.list());
				Projection projection2 = Projections.property(Searchstrings.getPreBel18());
				cr1.setProjection(projection2);
				Double premium = (Double) cr1.uniqueResult();

				pre1 = premium;
				Searchstrings.getLogger().info("new Premium is" + pre1);
				rec.setPremiumapplicable(pre1);
				Date regDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(regDate);
				Date newDate = calendar.getTime();
				calendar.setTime(newDate);
				calendar.add(Calendar.MINUTE, 3);
				Searchstrings.getLogger().info("Expiry Date is :" + calendar.getTime());
			
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getPree1(), pre1);

			}
			if (age > 18 && age < 60) {
				Criteria cr1 = session.createCriteria(Premium.class);
				System.out.println(premiumId1);
				cr1.add(Restrictions.eq(Searchstrings.getPremiumid(), premiumId1.getPremiumId()));
				System.out.println("list" + cr1.list());
				Projection projection2 = Projections.property(Searchstrings.getPre18to60());
				cr1.setProjection(projection2);
				Searchstrings.getLogger().info("premium for 18-60:" + cr1.uniqueResult());
				Double premium = (Double) cr1.uniqueResult();
				System.out.println("Premium fetched is:" + premium);

				pre1 = premium;
				Searchstrings.logger.info("new Premium is" + pre1);
				
				rec.setPremiumapplicable(pre1);
				Date regDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(regDate);
				Date newDate = calendar.getTime();
				calendar.setTime(newDate);
				calendar.add(Calendar.MINUTE, 3);
				Searchstrings.getLogger().info("Expiry Date is :" + calendar.getTime());
			
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getPree1(), pre1);

			}
			if (age > 60) {
				Criteria cr1 = session.createCriteria(Premium.class);
				cr1.add(Restrictions.eq(Searchstrings.getPremiumid(), premiumId1.getPremiumId()));
				System.out.println("list" + cr1.list());
				Projection projection2 = Projections.property(Searchstrings.getPreAbove60());
				cr1.setProjection(projection2);
				Double premium = (Double) cr1.uniqueResult();
				pre1 = premium;
				Searchstrings.getLogger().info("New Premium is" + pre1);
				rec.setPremiumapplicable(pre1);
				Date regDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(regDate);
				Date newDate = calendar.getTime();
				calendar.setTime(newDate);
				calendar.add(Calendar.MINUTE, 2);
				Searchstrings.getLogger().info("Expiry Date is :" + calendar.getTime());
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(Searchstrings.getPree1(), pre1);

			}

			return Searchstrings.getThanks71Xhtml();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Searchstrings.getError1Xhtml();
	}

	/**
	 * 
	 * @param healthId
	 * @return returns details of provider in rec_Insurance table based on
	 *         unique providerId
	 */
	public String getDeatails(String providerId) {

		try {
			Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(RecInsurance.class);
			cr.add(Restrictions.eq(Searchstrings.getProviderid(), providerId));
			Searchstrings.getLogger().info("Provider Id is:" + providerId);
			
			List<RecInsurance> list = cr.list();
			Searchstrings.getLogger().info("Size of List" + list.size());
			Searchstrings.getLogger().info("List is" + cr.list());
			
			RecInsurance pid = list.get(0);
			map.put(Searchstrings.getMed(), pid);
			return Searchstrings.getSearch1Xhtml();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Searchstrings.getSearch1Xhtml();

	}

	public List<RecInsurance> getPayId(String providerId) {
		String s = getDeatails(providerId);
		List<RecInsurance> pa = null;
		if (s != null) {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(RecInsurance.class);
			cr.add(Restrictions.eq(Searchstrings.getProviderid(), providerId));
			pa = cr.list();

		}
		return pa;
	}

	/**
	 * 
	 * @param providerId
	 * @param planId
	 * @param cId
	 * @param age
	 * @param premiumapplicable
	 * @param coverageapplicable
	 * @return Takes the ProviderId, planId, cId,age,premiumapplicable and
	 *         coverageapplicable and inserts into recInsurance table Returns a
	 *         Success page saying Policy Enroll Success if Policy is already
	 *         Taken then returns a Error Message
	 */

	@Override
	public String addProInsurance(String providerId, String planId, String cId, int age, double premiumapplicable,
			double coverageapplicable) {
		try {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Transaction trans = session.beginTransaction();
			RecInsurance rec = new RecInsurance();

			Date regDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(regDate);
			Date newDate = calendar.getTime();
			calendar.setTime(newDate);
			calendar.add(Calendar.YEAR, 1);
			
			Searchstrings.getLogger().info("Insurance ID Generated is" + rec.getInsuranceID());
			rec.setProviderId(providerId);
			rec.setcId(cId);
			rec.setPlanId(planId);
			rec.setPremiumapplicable(premiumapplicable);
			rec.setCoverageapplicable(coverageapplicable);
			rec.setStatus(Searchstrings.getActive());
			rec.setPolicybuydate(new Date());
			rec.setExpirydate(calendar.getTime());
			rec.setRole(Searchstrings.getProvider());
			session.save(rec);
			trans.commit();
			return Searchstrings.getThanks51Xhtml();
		}

		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Searchstrings.getError1Xhtml();

	}

	/**
	 * 
	 * @param providerId
	 * @return returns a list associated with the providerId passing from
	 *         rec_Insurance table
	 */

	@Override
	public List<RecInsurance> SearchInsurance(String providerId) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(Searchstrings.getProviderid(), providerId));
		List<RecInsurance> list = cr.list();

		return list;
	}

	/**
	 * 
	 * @param EnrollMentID
	 * @return returns a Unique row from rec_Insurance Table by matching with
	 *         the Unique Enrollment ID
	 */

	public RecInsurance searchByErId(String InsuranceID) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(Searchstrings.getInsuranceid(), InsuranceID));

		RecInsurance re = (RecInsurance) cr.uniqueResult();
		System.out.println(re);
		return re;
	}

	/**
	 * 
	 * @param InsuranceID
	 * @param providerId
	 * @param planId
	 * @param cId
	 * @return Renews the already taken Insurance extends the Expiry Date to one
	 *         year starting from current date and updates the rec_Insurance
	 *         table Returns a Success page After Completion of Renewal.
	 */

	@Override
	public String RenewInsuranceDao(String InsuranceID, String providerId, String planId, String cId) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		RecInsurance rec = searchByErId(InsuranceID);
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(Searchstrings.getProviderid(), providerId));
		cr.add(Restrictions.eq(Searchstrings.getPlanid(), planId));
		cr.add(Restrictions.eq(Searchstrings.getCid(), cId));
		cr.add(Restrictions.eq(Searchstrings.getInsuranceid(), InsuranceID));
		Projection projection = Projections.property(Searchstrings.getExpirydate());
		cr.setProjection(projection);
		
		Date regDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(regDate);
		Date newDate = calendar.getTime();
		calendar.setTime(newDate);
		calendar.add(Calendar.YEAR, 1);
		
		Date date2 = calendar.getTime();
		rec.setPolicybuydate(new Date());
		rec.setExpirydate(date2);
		Searchstrings.getLogger().info("Updated Date" + calendar.getTime());
		rec.setStatus(Searchstrings.getActive());
		Transaction trans = session.beginTransaction();
		session.update(rec);
		trans.commit();
		session.close();
		return Searchstrings.getThanks41Xhtml();
	}
}
