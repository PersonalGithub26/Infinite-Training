package com.java.employ;

	

	import java.io.Serializable;

	public class Employ implements Serializable{
		private int empNo;
	    private String name;
	    private Gender gender;
	    private String dept;
	    private String desig;
	    private double basic;


	    public int getEmpNo() {
	        return empNo;
	    }
	    public void setEmpNo(int empNo) {
	        this.empNo = empNo;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public Gender getGender() {
	        return gender;
	    }
	    public void setGender(Gender gender) {
	        this.gender = gender;
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
	    @Override
	    public String toString() {
	        return "Employee [empNo=" + empNo + ", name=" + name + ", gender=" + gender + ", dept=" + dept + ", desig="
	                + desig + ", basic=" + basic + "]";
	    }
	    public Employ(int empNo, String name, Gender gender, String dept, String desig, double basic) {
	        this.empNo = empNo;
	        this.name = name;
	        this.gender = gender;
	        this.dept = dept;
	        this.desig = desig;
	        this.basic = basic;
	    }
		public Employ() {
			// TODO Auto-generated constructor stub
		}


	}



