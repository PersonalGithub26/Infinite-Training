package com.java.LMSProjectJstl;

import java.sql.SQLException;
import java.util.List;

public interface EmployDAO {
	public List<Employ> showEmployDao() throws ClassNotFoundException, SQLException;
	public Employ SearchEmploy(int empId) throws SQLException, ClassNotFoundException;
}
