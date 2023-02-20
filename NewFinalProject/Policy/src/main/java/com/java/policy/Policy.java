package com.java.policy;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "policy_details")
@ManagedBean
@SessionScoped

public class Policy {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pid")
	private String pid;
	
	@Column(name = "pname")	
	private String pname;
	
	@Column(name = "cname")
	private String cname;
	
	@Column(name = "premium")
	private double premium;
	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "buydate")
	private Date buydate;
	
	
	@Column(name = "activedate")
	private Date activedate;
	
	
	@Column(name = "enddate")
	private Date enddate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	public Date getActivedate() {
		return activedate;
	}
	public void setActivedate(Date activedate) {
		this.activedate = activedate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", pid=" + pid + ", pname=" + pname + ", cname=" + cname + ", premium=" + premium
				+ ", status=" + status + ", buydate=" + buydate + ", activedate=" + activedate + ", enddate=" + enddate
				+ "]";
	}
	

	
	
}
