package com.jsf.Demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Employ {
	
	private int empId;
	private String name;
	private String dept;
	private String desig;
	private double basic;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public Employ(int empId, String name, String dept, String desig, double basic) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}
	
	

}
