package com.java.project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import org.apache.log4j.Logger;

import com.java.infinite.DaoImpl.SignUpDaoImpl;

@ManagedBean(name = "Stringcon")
@SessionScoped

public class Searchstrings {
	public static final String USER_NAME = "username";
	public static final String PROVIDER_EMAIL = "providerEmailId";
	public static final String PLANID = "planId";
	public static final String COV1 = "cov1";
	public static final String PREM = "prem";
	public static final String PREMIUMID = "premiumId";
	public static final String PRE_BEL_18 = "premium_bel_18";
	public static final String PRE_18to60 = "premium_18to60";
	public static final String PREE1 = "pree1";
	public static final String PRE_ABOVE_60 = "premium_above60";
	public static final String ACTIVE = "ACTIVE";
	public static final String PROVIDER = "PROVIDER";
	public static final String THANKS71_XHTML = "Thanks71.xhtml?faces-redirect=true";
	public static final String ERROR1_XHTML = "error1.xhtml?faces-redirect=true";
	public static final String PROVIDERID = "providerId";
	public static final String MED = "med";
	public static final String SEARCH1_XHTML = "Search1.xhtml?faces-redirect=true";
	public static final Logger logger = Logger.getLogger(SignUpDaoImpl.class);
	public static final String CID = "cId";
	public static final String EXPIRYDATE = "expirydate";
	public static final String THANKS41_XHTML = "Thanks41.xhtml?faces-redirect=true";
	public static final String THANKS51_XHTML = "Thanks51.xhtml?faces-redirect=true";
	public static final String RE04d = "RE%04d";
	public static final String PROVIDER_LOGIN_XHTML = "ProviderLogin.xhtml?faces-redirect=true";
	public static final String PROVIDERINFO1 = "providerInfo1";
	public static final String BUYorRENEW1_XHTML = "buyorrenew1.xhtml?faces-redirect=true";
	public static final String ERROR_MSG = "Invalid Credentials Either UserName or MailId is Wrong...";
	public static final String ERRORR = "error";
	public static final String INSURANCEID ="InsuranceID";
	public static final String SHOW_XHTML="Show.xhtml?faces-redirect=true";
	/*private static final Logger logger = LogManager.getLogger(SignUpDaoImpl.class);*/
	public static final String COMPANYNAME="companyName";
	
	public static String getUserName() {
		return USER_NAME;
	}
	
	public static String getProviderEmail() {
		return PROVIDER_EMAIL;
	}

	public static String getPlanid() {
		return PLANID;
	}
	public static String getCov1() {
		return COV1;
	}
	public static String getPrem() {
		return PREM;
	}
	public static String getPremiumid() {
		return PREMIUMID;
	}
	public static String getPreBel18() {
		return PRE_BEL_18;
	}
	public static String getPre18to60() {
		return PRE_18to60;
	}
	public static String getPree1() {
		return PREE1;
	}
	public static String getPreAbove60() {
		return PRE_ABOVE_60;
	}
	public static String getActive() {
		return ACTIVE;
	}
	
	
	public static String getProvider() {
		return PROVIDER;
	}

	public static String getThanks71Xhtml() {
		return THANKS71_XHTML;
	}

	
	public static String getError1Xhtml() {
		return ERROR1_XHTML;
	}

	
	public static String getProviderid() {
		return PROVIDERID;
	}

	public static String getMed() {
		return MED;
	}
	
	
	public static String getSearch1Xhtml() {
		return SEARCH1_XHTML;
	}

	public static String getCid() {
		return CID;
	}
	public static String getExpirydate() {
		return EXPIRYDATE;
	}
	
	
	public static String getThanks41Xhtml() {
		return THANKS41_XHTML;
	}

	public static String getThanks51Xhtml() {
		return THANKS51_XHTML;
	}

	public static String getRe04d() {
		return RE04d;
	}
	
	
	public static String getProviderLoginXhtml() {
		return PROVIDER_LOGIN_XHTML;
	}

	public static String getProviderinfo1() {
		return PROVIDERINFO1;
	}

	
	public static String getBuyorrenew1Xhtml() {
		return BUYorRENEW1_XHTML;
	}

	public static String getErrorMsg() {
		return ERROR_MSG;
	}
	public static String getErrorr() {
		return ERRORR;
	}
	public static String getInsuranceid() {
		return INSURANCEID;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static String getShowXhtml() {
		return SHOW_XHTML;
	}

	public static String getCompanyname() {
		return COMPANYNAME;
	}
	
	
	/*public static Logger getLogger() {
		return logger;
	}*/

	

}
