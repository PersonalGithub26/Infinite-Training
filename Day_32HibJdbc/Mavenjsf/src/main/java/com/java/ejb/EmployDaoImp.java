package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@ManagedBean(name="edao")
@SessionScoped
public class EmployDaoImp{
	
	private List<Employ> employs;
	
	

	public List<Employ> getEmploys() {
		return employs;
	}



	public void setEmploys(List<Employ> employs) {
		this.employs = employs;
	}

	public EmployDaoImp() throws NamingException, ClassNotFoundException, SQLException
	{
		EmployCrudBeanRemoteRemote remote = (EmployCrudBeanRemoteRemote) new InitialContext().lookup("EmployCrudBeanRemote/remote");
		employs = remote.showEmployBean();
		this.employs=employs;
	}

	public List<Employ> showEmploy() throws NamingException, ClassNotFoundException, SQLException{
		EmployCrudBeanRemoteRemote remote = (EmployCrudBeanRemoteRemote) new InitialContext().lookup("EmployCrudBeanRemote/remote");
		List<Employ> list = remote.showEmployBean();
		for (Employ employ : list) {
			System.out.println(employ.toString());
		}
		
		return list;
	}
	
}
