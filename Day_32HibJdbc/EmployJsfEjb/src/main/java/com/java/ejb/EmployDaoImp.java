package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@ManagedBean(name="dao")
@SessionScoped
public class EmployDaoImp{
	
	private List<Employ> allEmploys;
	
	

	public List<Employ> getAllEmploys() {
		return allEmploys;
	}



	public void setAllEmploys(List<Employ> allEmploys) {
		this.allEmploys = allEmploys;
	}



	public List<Employ> showEmploy() throws NamingException, ClassNotFoundException, SQLException{
		EmployCrudBeanRemoteRemote remote = (EmployCrudBeanRemoteRemote) new InitialContext().lookup("EmployCrudBeanRemote/remote");
		List<Employ> list = remote.showEmployBean();
		for (Employ employ : list) {
			System.out.println(employ);
		}
		return list;
	}
	
}
