package com.jsf.Demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="fname")
@SessionScoped

public class FullName {
	
	private String firstName;
	private String LastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String fullNam()
	{
		return firstName+LastName;
	}
		
	

}
