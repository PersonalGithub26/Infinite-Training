package com.java.jsf;

public class MainCompany {
	
	public static void main(String[] args) {
		
		CompanyDaoImp dao = new CompanyDaoImp();
		InsuranceDaoImp imp = new InsuranceDaoImp();
		System.out.println(dao.showCompanyNames());
		System.out.println(dao.searchCompanyToGetId("HDFC"));
		System.out.println("====================================");
		System.out.println(imp.showPolicies());
		System.out.println(imp.searchPolicyTypeToGetId("q"));
		System.out.println(imp.getInsuranceDetails("I001"));
		
	}

}
