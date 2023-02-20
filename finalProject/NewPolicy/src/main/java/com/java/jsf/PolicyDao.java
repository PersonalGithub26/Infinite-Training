package com.java.jsf;


import java.util.Date;
import java.util.List;

public interface PolicyDao {
	
	
	String addPolicy(Policy policy);
	
	List<Policy> showPolicy();
	String deletePolicyDao(String pid);

}
