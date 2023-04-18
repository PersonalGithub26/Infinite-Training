package com.java.jsf;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SessionScoped
@ManagedBean
@Table(name = "insurance")
public class Insurance {
	
	@Id
	@Column(name = "planId")
	private String planId;
	@Column(name = "cId")
	private String cId;
	@Column(name = "coverage")
	private double coverage;
	@Column(name = "duration")
	private int duration;
	@Column(name = "expiryDate")
	private Date exipryDate;
	@Column(name = "keyBenifits")
	private String keyBenifits;
	@Column(name = "launchDate")
	private Date launchDate;
	@Column(name = "planName")
	private String planName;
	
	@Column(name = "planType")
	private String planType;
	
	@Column(name = "premium")
	private double premium;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
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
	public Date getExipryDate() {
		return exipryDate;
	}
	public void setExipryDate(Date exipryDate) {
		this.exipryDate = exipryDate;
	}
	public String getKeyBenifits() {
		return keyBenifits;
	}
	public void setKeyBenifits(String keyBenifits) {
		this.keyBenifits = keyBenifits;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Insurance [planId=" + planId + ", cId=" + cId + ", coverage=" + coverage + ", duration=" + duration
				+ ", exipryDate=" + exipryDate + ", keyBenifits=" + keyBenifits + ", launchDate=" + launchDate
				+ ", planName=" + planName + ", planType=" + planType + ", premium=" + premium + ", status=" + status
				+ "]";
	}
	
	
	

}
