package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@ManagedBean
@SessionScoped
public class Company {
	
	@Id
	@Column(name = "cId")
	private String cId;
	@Column(name = "address")
	private String address;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "contact")
	private String contact;
	@Column(name = "email")
	private String email;
	@Column(name = "website")
	private String website;
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "Company [cId=" + cId + ", address=" + address + ", companyName=" + companyName + ", contact=" + contact
				+ ", email=" + email + ", website=" + website + "]";
	}
	
	
	
	

}
