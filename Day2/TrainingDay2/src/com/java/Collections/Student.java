package com.java.Collections;

public class Student implements Comparable {
	int sno;
	String name;
	String city;
	double cgp;
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", city=" + city + ", cgp=" + cgp + "]";
	}
	public Student(int sno, String name, String city, double cgp) {
		
		this.sno = sno;
		this.name = name;
		this.city = city;
		this.cgp = cgp;
	}
	public Student() {
		
	}
	@Override
	public int compareTo(Object o) {
		Student student = (Student)o;
		return name.compareTo(student.name);
		
	}
	
	
	

}
