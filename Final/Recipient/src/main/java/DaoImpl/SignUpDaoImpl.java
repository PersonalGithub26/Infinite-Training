package com.java.infinite.DaoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.java.hms.Company;
import com.java.hms.Insurance;
import com.java.hms.Premium;
import com.java.hms.RecInsurance;
import com.java.hms.SessionHelper;
import com.java.infinite.Dao.SignUpRespDao;
import com.java.infinite.Recipient.Login;
import com.java.infinite.Recipient.SignUpRecipient;

@ManagedBean(name = "sDao")
@SessionScoped
public class SignUpDaoImpl implements SignUpRespDao {
	double pre1;

	public double getPre1() {
		return pre1;
	}

	public void setPre1(double pre1) {
		this.pre1 = pre1;
	}
	String planName;
	
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}
	String companyName;
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String generateHealthId() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		Criteria cr = session.createCriteria(SignUpRecipient.class);
		cr.setProjection(Projections.max("healthId"));
		String str = (String) cr.uniqueResult();

		String sub = str.substring(2);
		int hId = Integer.parseInt(sub);
		hId++;
		return String.format("RE%04d", hId);

	}

	@Override
	public String addresp(SignUpRecipient signupresp, Login login) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String hId = generateHealthId();
		signupresp.setHealthId(hId);
		String pwd = EntryptPassword.getCode(login.getPassword());
		login.setPassword(pwd);
		Transaction t = session.beginTransaction();
		signupresp.setLogin(login);
		session.save(login);
		session.save(signupresp);
		t.commit();
		SearchStrings.getLogger().info("Record Inserted");

		return "ThanksRecipient.xhtml?faces-redirect=true";
	}

	/**
	 * 
	 * @param re
	 *            returns 0 if Expire date is grater than Current Date returns 2
	 *            if Expire date is less than Current Date
	 */
	public int forbutton(RecInsurance re) {

		String uId = re.getInsuranceID();
		RecInsurance r = searchByErId(uId);
		Date exp = r.getExpirydate();
		Date regDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(regDate);
		Date newDate = calendar.getTime();
		calendar.setTime(newDate);
		if (exp.compareTo(new Date()) > 0) {

			SearchStrings.getLogger().info("Active policy");
			return 0;
		}

		else {
			SearchStrings.getLogger().info("Inactive policy");
			return 2;
		}

	}

	/**
	 * 
	 * @param signupresp
	 * @return
	 * 
	 * 	returns the policy Buying page after matching the Username and
	 *  email in the signuprecipient Table
	 */

	@Override
	public String validateMe(SignUpRecipient signupresp) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(SignUpRecipient.class);

		cr.add(Restrictions.eq(SearchStrings.getUserName(), signupresp.getFirstName()));
		cr.add(Restrictions.eq(SearchStrings.getEmail(), signupresp.getMobileNo()));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		if (count == 1) {
			SignUpRecipient r = searchByRecipientName(signupresp.getFirstName(), signupresp.getMobileNo());

			sessionMap.put(SearchStrings.getRecipientinfo1(), r);
			SearchStrings.getLogger().info("Login Success IN LOGGER MODE");
			return SearchStrings.getBuyorrenewXhtml();

		} else {
			sessionMap.put(SearchStrings.getErrorr(), SearchStrings.getErrorMsg());
			// session.close();
		}

		return SearchStrings.getRecipientLoginXhtml();
	}

	/**
	 * 
	 * @param userName
	 * @param email
	 * @return Takes the userName and email as input and Goes into
	 *         signuprecipient table matches these 2 parameters and returns a
	 *         Unique row object
	 */
	@Override
	public SignUpRecipient searchByRecipientName(String userName, String email) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(SignUpRecipient.class);
		cr.add(Restrictions.eq(SearchStrings.getUserName(), userName));
		cr.add(Restrictions.eq(SearchStrings.getEmail(), email));

		SignUpRecipient signupresp = (SignUpRecipient) cr.uniqueResult();
		return signupresp;
	}

	/**
	 * 
	 * @param dateOfBirth
	 * @return Takes the Date as Input and Calculates age with the Corresponding
	 *         Date,
	 */

	public int calculateAge(Date dateOfBirth) {
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
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @param age
	 * @return Calculates Premium and Coverage Based on age of Recipient And
	 *         returns the Details of Selected Policy
	 */

	@Override
	public String Calculatepremium(String healthId, String planId, String cId, int age) {
		try {

			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Transaction trans = session.beginTransaction();

			RecInsurance rec = new RecInsurance();

			Criteria cr = session.createCriteria(Insurance.class);
			cr.add(Restrictions.eq(SearchStrings.getPlanid(), planId));
			Insurance ins = (Insurance) cr.uniqueResult();
			planName=ins.getPlanName();
			System.out.println("Plan Name is "+planName);
			String CID = ins.getcId();
			Company com = new Company();
			Criteria cr6 = session.createCriteria(Company.class);
			cr6.add(Restrictions.eq("cId", CID));
			Projection projection6 = Projections.property("companyName");
			cr6.setProjection(projection6);
			companyName=(String) cr6.uniqueResult();
			
			
			
			
			
			if (age <= 18) {

				// rec.setCoverageapplicable(ins.getCoverage_bel_18());
				double covfor18 = ins.getCoverage_bel_18();

				SearchStrings.getLogger().info(covfor18);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getCov1(), covfor18);
			}
			if (age > 18 && age < 60) {
				// rec.setCoverageapplicable(ins.getCoverage_18to60());
				double covfor18to60 = ins.getCoverage_18to60();

				SearchStrings.getLogger().info(covfor18to60);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getCov1(), covfor18to60);
			}
			if (age >= 60) {
				// rec.setCoverageapplicable(ins.getCoverage_above60());
				double covfor60 = ins.getCoverage_above60();
				System.out.println(covfor60);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getCov1(), covfor60);
			}
			Projection projection = Projections.property(SearchStrings.getPrem());
			cr.setProjection(projection);

			Premium premiumId1 = (Premium) cr.uniqueResult();

			SearchStrings.getLogger().info("premiumid:" + premiumId1.getPremiumId());
			SearchStrings.getLogger().info(premiumId1.getPremiumId());

			if (age <= 18) {

				Criteria cr1 = session.createCriteria(Premium.class);
				System.out.println(premiumId1);
				cr1.add(Restrictions.eq(SearchStrings.getPremiumid(), premiumId1.getPremiumId()));
				System.out.println("list" + cr1.list());
				Projection projection2 = Projections.property(SearchStrings.getPreBel18());
				cr1.setProjection(projection2);
				Double premium = (Double) cr1.uniqueResult();

				pre1 = premium;
				SearchStrings.getLogger().info("new Premium is" + pre1);
				rec.setPremiumapplicable(pre1);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getPree1(), pre1);

			}
			if (age > 18 && age < 60) {
				Criteria cr1 = session.createCriteria(Premium.class);
				System.out.println(premiumId1);
				cr1.add(Restrictions.eq(SearchStrings.getPremiumid(), premiumId1.getPremiumId()));
				System.out.println("list" + cr1.list());
				Projection projection2 = Projections.property(SearchStrings.getPre18to60());
				cr1.setProjection(projection2);
				SearchStrings.getLogger().info("premium for 18-60:" + cr1.uniqueResult());

				Double premium = (Double) cr1.uniqueResult();
				SearchStrings.getLogger().info("Premium fetched is:" + premium);

				pre1 = premium;
				SearchStrings.getLogger().info("new Premium is" + pre1);

				rec.setPremiumapplicable(pre1);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getPree1(), pre1);
				// session.save(rec);
				// trans.commit();

			}
			if (age > 60) {
				Criteria cr1 = session.createCriteria(Premium.class);
				SearchStrings.getLogger().info(premiumId1);

				cr1.add(Restrictions.eq(SearchStrings.getPremiumid(), premiumId1.getPremiumId()));
				SearchStrings.getLogger().info("list" + cr1.list());

				Projection projection2 = Projections.property(SearchStrings.getPreAbove60());
				cr1.setProjection(projection2);

				Double premium = (Double) cr1.uniqueResult();
				// System.out.println("Premium fetched is:"+premium);
				pre1 = premium;
				SearchStrings.getLogger().info("new Premium is" + pre1);
				rec.setPremiumapplicable(pre1);
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				sessionMap.put(SearchStrings.getPree1(), pre1);
				// session.save(rec);
				// trans.commit();
			}

			return SearchStrings.getThanks61Xhtml();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SearchStrings.getErrorXhtml();
	}

	/**
	 * 
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @param age
	 * @param premiumapplicable
	 * @param coverageapplicable
	 * @return Takes the Health Id, planId, cId,age,premiumapplicable and
	 *         coverageapplicable and inserts into recInsurance table Returns a
	 *         Success page saying Policy Enroll Success if Policy is already
	 *         Taken then returns a Error Message
	 */
	@Override
	public String addRecInsurance(String healthId, String planId, String cId, int age, double premiumapplicable,
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

			rec.setHealthId(healthId);
			rec.setcId(cId);
			rec.setPlanId(planId);
			rec.setPremiumapplicable(premiumapplicable);
			rec.setCoverageapplicable(coverageapplicable);
			rec.setStatus(SearchStrings.getActive());
			rec.setPolicybuydate(new Date());
			rec.setExpirydate(calendar.getTime());
			rec.setRole(SearchStrings.getRecipient());
			session.save(rec);
			trans.commit();
			return SearchStrings.getThanks5Xhtml();
		}

		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SearchStrings.getErrorXhtml();

	}

	/**
	 * 
	 * @param healthId
	 * @return returns a list associated with the healthId passing from
	 *         rec_Insurance table
	 */
	@Override
	public List<RecInsurance> SearchInsurance(String healthId) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(SearchStrings.getHealthid(), healthId));
		List<RecInsurance> list = cr.list();

		return list;
	}

	private String hId;

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	/**
	 * 
	 * @param healthId
	 * @return returns details of Recipient in rec_Insurance table based on
	 *         unique healthId
	 */
	public String getDeatails(String healthId) {

		try {
			Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(RecInsurance.class);
			cr.add(Restrictions.eq(SearchStrings.getHealthid(), healthId));
			List<RecInsurance> list = cr.list();
			SearchStrings.getLogger().info(healthId);
			SearchStrings.getLogger().info(list.size());
			SearchStrings.getLogger().info("List is" + cr.list());

			RecInsurance pid = list.get(0);
			map.put(SearchStrings.getMed(), pid);

		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			return SearchStrings.getSearchXhtml();

		}
		return SearchStrings.getSearchXhtml();
	}

	public List<RecInsurance> getPayId(String healthId) {
		String s = getDeatails(healthId);
		List<RecInsurance> pa = null;
		if (s != null) {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(RecInsurance.class);
			cr.add(Restrictions.eq(SearchStrings.getHealthid(), healthId));
			pa = cr.list();

		}
		return pa;
	}

	/**
	 * 
	 * @param EnrollMentID
	 * @return returns a Unique row based on Enrollment ID in rec_Insurance
	 *         Table
	 */
	public RecInsurance searchByErId(String InsuranceID) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(SearchStrings.getInsuranceid(), InsuranceID));
		RecInsurance re = (RecInsurance) cr.uniqueResult();
		System.out.println(re);
		return re;
	}

	/**
	 * 
	 * @param InsuranceID
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @return Renews the already taken Insurance extends the Expiry Date to one
	 *         year starting from current date and updates the rec_Insurance
	 *         table Returns a Success page After Completion of Renewal.
	 */

	@Override
	public String RenewInsuranceDao(String InsuranceID, String healthId, String planId, String cId) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		RecInsurance rec = searchByErId(InsuranceID);
		Criteria cr = session.createCriteria(RecInsurance.class);
		cr.add(Restrictions.eq(SearchStrings.getHealthid(), healthId));
		cr.add(Restrictions.eq(SearchStrings.getPlanid(), planId));
		cr.add(Restrictions.eq(SearchStrings.getCid(), cId));
		cr.add(Restrictions.eq(SearchStrings.getInsuranceid(), InsuranceID));
		Projection projection = Projections.property(SearchStrings.getExpirydate());
		cr.setProjection(projection);

		
		Date regDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(regDate);
		Date newDate = calendar.getTime();
		calendar.setTime(newDate);
		calendar.add(Calendar.YEAR, 1);
		
		SearchStrings.getLogger().info("Updated Date" + calendar.getTime());
		Date date2 = calendar.getTime();
		SearchStrings.getLogger().info("Date in Variable is" + date2);
		rec.setPolicybuydate(new Date());
		rec.setExpirydate(date2);
		SearchStrings.getLogger().info("Updated Date" + rec.getExpirydate());
		rec.setStatus(SearchStrings.getActive());
		Transaction trans = session.beginTransaction();
		session.update(rec);
		trans.commit();
		session.close();
		return SearchStrings.getThanks4Xhtml();
	}

}
