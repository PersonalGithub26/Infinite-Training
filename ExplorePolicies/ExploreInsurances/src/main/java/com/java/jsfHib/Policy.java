package com.java.jsfHib;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ManagedBean
@Table(name = "policies")
@SessionScoped
public class Policy {
	@Id
	@Column(name = "plainId")
	private String planId;
	@Column(name = "cId")
	private String cId;
	@Column(name = "coverage")
	private double coverage;
	@Column(name = "duration")
	private int duration;
	@Column(name = "expiryDate")
	private Date expiryDate;
	@Column(name = "launchDate")
	private Date launchDate;
	@Column(name = "planName")
	private String planName;
	@Column(name = "planType")
	private String planType;
	@Column(name = "premium")
	private double premium;
	@Column(name = "status")
	private String Status;
	@Column(name = "Key_Benifits")
	private String keyBenifits;
	
	
	
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Policy [planId=" + planId + ", cId=" + cId + ", coverage=" + coverage + ", duration=" + duration
				+ ", expiryDate=" + expiryDate + ", launchDate=" + launchDate + ", planName=" + planName + ", planType="
				+ planType + ", premium=" + premium + ", Status=" + Status + "]";
	}
	
	

}
