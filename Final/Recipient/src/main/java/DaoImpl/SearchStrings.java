package com.java.infinite.DaoImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/


import org.apache.log4j.Logger;

@ManagedBean(name = "literals")
@SessionScoped

public class SearchStrings {
	public static final String USER_NAME = "userName";
	public static final String EMAIL = "email";
	public static final String PLANID = "planId";
	public static final String COV1 = "cov1";
	public static final String PREM = "prem";
	public static final String PREMIUMID = "premiumId";
	public static final String PRE_BEL_18 = "premium_bel_18";
	public static final String PRE_18to60 = "premium_18to60";
	public static final String PREE1 = "pree1";
	public static final String PRE_ABOVE_60 = "premium_above60";
	public static final String ACTIVE = "ACTIVE";
	public static final String RECIPIENT = "RECIPIENT";
	public static final String THANKS61_XHTML = "Thanks61.xhtml?faces-redirect=true";
	public static final String ERROR_XHTML = "error.xhtml?faces-redirect=true";
	public static final String HEALTHID = "healthId";
	public static final String MED = "med";
	public static final String SEARCH_XHTML = "Search.xhtml?faces-redirect=true";
	public static final Logger logger = Logger.getLogger(SignUpDaoImpl.class);
	public static final String CID = "cId";
	public static final String EXPIRYDATE = "expirydate";
	public static final String THANKS4_XHTML = "Thanks4.xhtml?faces-redirect=true";
	public static final String THANKS5_XHTML = "Thanks5.xhtml?faces-redirect=true";
	public static final String RE04d = "RE%04d";
	public static final String RECIPIENT_LOGIN_XHTML = "RecipientLogin.xhtml";
	public static final String RECIPIENTINFO1 = "recipientInfo1";
	public static final String BUYorRENEW_XHTML = "buyorreneew.xhtml?faces-redirect=true";
	public static final String ERROR_MSG = "Invalid Credentials Either UserName or MailId is Wrong...";
	public static final String ERRORR = "error";
	public static final String INSURANCEID ="InsuranceID";
	
	
	public static String getUserName() {
		return USER_NAME;
	}
	public static String getEmail() {
		return EMAIL;
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
	public static String getRecipient() {
		return RECIPIENT;
	}
	public static String getThanks61Xhtml() {
		return THANKS61_XHTML;
	}
	public static String getErrorXhtml() {
		return ERROR_XHTML;
	}
	public static String getHealthid() {
		return HEALTHID;
	}
	public static String getMed() {
		return MED;
	}
	public static String getSearchXhtml() {
		return SEARCH_XHTML;
	}
	
	public static String getCid() {
		return CID;
	}
	public static String getExpirydate() {
		return EXPIRYDATE;
	}
	public static String getThanks4Xhtml() {
		return THANKS4_XHTML;
	}
	public static String getThanks5Xhtml() {
		return THANKS5_XHTML;
	}
	public static String getRe04d() {
		return RE04d;
	}
	public static String getRecipientLoginXhtml() {
		return RECIPIENT_LOGIN_XHTML;
	}
	public static String getRecipientinfo1() {
		return RECIPIENTINFO1;
	}
	public static String getBuyorrenewXhtml() {
		return BUYorRENEW_XHTML;
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
	
	/*public static Logger getLogger() {
		return logger;
	}*/

	

}
