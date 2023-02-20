package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployCrudBeanRemote
 */
@Stateless
@Remote(EmployCrudBeanRemoteRemote.class)
public class EmployCrudBeanRemote implements EmployCrudBeanRemoteRemote {
	static EmployDAO edao;
	
	static
	{
		edao = new EmployDAO();
	}

    /**
     * Default constructor. 
     */
    public EmployCrudBeanRemote() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Employ> showEmployBean() throws ClassNotFoundException, SQLException {
		List<Employ> list = edao.showEmploy();
		return list;
	}

	@Override
	public Employ searchEmployBean(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addEmployBean(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployBean(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployBean(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
