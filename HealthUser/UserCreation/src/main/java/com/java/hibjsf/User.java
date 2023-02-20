package com.java.hibjsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@ManagedBean
@SessionScoped
public class User {
	@Id
	@Column(name = "userId")
	private int userId;
	@Column(name = "FullName")
	private String fullName;
	@Column(name = "userName")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "profilePassword")
	private String profilePassword;
	@Column(name = "gender")
	private Gender gender;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "email")
	private String email;
	@Column(name = "securityQuestion")
	private Questions question;
	@Column(name = "securityAnswer")
	private String answer;
	@Column(name = "hobbies")
	private String hobbies;
	
	
	
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePassword() {
		return profilePassword;
	}
	public void setProfilePassword(String profilePassword) {
		this.profilePassword = profilePassword;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password
				+ ", profilePassword=" + profilePassword + ", gender=" + gender + ", mobile=" + mobile + ", email="
				+ email + ", question=" + question + ", answer=" + answer + ", hobbies=" + hobbies + "]";
	}
	
	
	
	
}
