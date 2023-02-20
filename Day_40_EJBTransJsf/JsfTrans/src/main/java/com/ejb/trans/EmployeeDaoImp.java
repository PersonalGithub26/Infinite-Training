package com.ejb.trans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@SessionScoped
@ManagedBean(name = "eDao")
public class EmployeeDaoImp {

	private List<Employee> employees;
	
	@EJB
	private Bean bean;
	
	
	
	
	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public EmployeeDaoImp() throws NamingException {
	    System.out.println("EmployeeDaoImp constructor called");
	    EmployeeRemote remote = (EmployeeRemote) new InitialContext().lookup("ManageEmployeeBean/remote");
	    employees = remote.showEmploy();
	}
	
	public List<Employee> showList() throws NamingException
	{
		List<Employee> employees = bean.showEmploye();
		return employees;
	}
	
	
	
				
	

	
}
