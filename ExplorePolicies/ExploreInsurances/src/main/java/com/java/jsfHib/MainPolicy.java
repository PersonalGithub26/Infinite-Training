package com.java.jsfHib;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainPolicy {

	public static void main(String[] args) {
		
//		CompanyDaoImpl impl = new CompanyDaoImpl();
//		System.out.println(impl.showCompanyNames());
//		System.out.println(impl.searchCompanyToGetId("ICICI"));
//		PolicyDaoImp2 imp = new PolicyDaoImp2(); 
//		System.out.println(imp.showPoliciesnew());
		PolicyDaoImp daoImp = new PolicyDaoImp(); 
		System.out.println(daoImp.showPolicyNamesByCompId());
	}
}

