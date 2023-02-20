package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ManagedBean(name = "edao")
@SessionScoped
public class EmployDaoImp {

	private List<Employ> employs;

	public List<Employ> getEmploys() {
		return employs;
	}

	public void setEmploys(List<Employ> employs) {
		this.employs = employs;
	}

	public EmployDaoImp() throws NamingException, ClassNotFoundException, SQLException {
		TestRemote remote = (TestRemote) new InitialContext().lookup("Test/remote");
		this.employs = remote.showEmployBean();
	}

}
