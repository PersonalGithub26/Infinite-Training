package com.java.infinite.Recipient;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.annotation.Generated;

@ManagedBean(name="login")
@SessionScoped
@Entity
@Table(name="login")



public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "loginId")
	private Integer loginId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="Otp")
	private long otp;
	
	@Column(name="Otpsendtime")
	private Date otpSendtime;
	
	
	
	
	

	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getOtp() {
		return otp;
	}
	public void setOtp(long otp) {
		this.otp = otp;
	}
	public Date getOtpSendtime() {
		return otpSendtime;
	}
	public void setOtpSendtime(Date otpSendtime) {
		this.otpSendtime = otpSendtime;
	}
}