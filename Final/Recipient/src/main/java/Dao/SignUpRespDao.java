package com.java.infinite.Dao;

import java.util.List;

import com.java.hms.RecInsurance;
import com.java.infinite.Recipient.Login;
import com.java.infinite.Recipient.SignUpRecipient;

public interface SignUpRespDao {
	
	String addresp(SignUpRecipient signupresp, Login login);
	String generateHealthId();
	SignUpRecipient searchByRecipientName(String userName, String email);
	/**
	 * 
	 * @param signupresp
	 * @return
	 */
	String validateMe(SignUpRecipient signupresp);
	/**
	 * 
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @param age
	 * @return
	 */
	String Calculatepremium(String healthId,String planId,String cId,int age);
	/**
	 * 
	 * @param healthId
	 * @return
	 */
	public List<RecInsurance> SearchInsurance(String healthId);
	/**
	 * 
	 * @param EnrollMentID
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @return
	 */
	String RenewInsuranceDao(String InsuranceID,String healthId,String planId, String cId);
	/**
	 * 
	 * @param healthId
	 * @param planId
	 * @param cId
	 * @param age
	 * @param premiumapplicable
	 * @param coverageapplicable
	 * @return
	 */
	String addRecInsurance(String healthId,String planId,String cId,int age,double premiumapplicable,double coverageapplicable);

}
