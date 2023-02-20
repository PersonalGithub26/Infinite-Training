package com.java.lms;

import java.sql.SQLException;

public interface LmsDAO {

	
	java.util.List<Employee> showEmployee() throws SQLException, ClassNotFoundException;

	Employee showOne(int id) throws ClassNotFoundException, SQLException;
	
	
}
