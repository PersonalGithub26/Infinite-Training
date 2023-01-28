package com.namedQuery;

import java.util.List;

public interface EmployDAO {
	
	List<Employ> showEmployDao();
	String searchEmploy(int empno);
	String validateMe(Login1 login);

}
