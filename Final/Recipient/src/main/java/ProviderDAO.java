package com.java.project;

import java.util.List;

import com.java.hms.RecInsurance;

public interface ProviderDAO {

	String addProvider(Provider provider);
	List<Provider> showProvider();
	String validateMe(Provider provider);
	Provider searchByProviderName(String username, String providerEmailId);
	String Calculatepremium(String providerId,String planId,String cId,int age);
	public List<RecInsurance> SearchInsurance(String providerId);
	//String addProviderInsuranceDao(String planId,String providerId,String cId,int age);
	String RenewInsuranceDao(String InsuranceID,String providerId,String planId, String cId);
	String addProInsurance(String providerId,String planId,String cId,int age,double premiumapplicable,double coverageapplicable);
}
