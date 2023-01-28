package com.java.employeeLeave;


import java.util.List;

public interface LeaveDAO {
	
	String addLeave(Leave1 leave);
	List<Leave1> showLeaves();
	Leave1 searchEmpDao(int empno);
	String deletLeaveDao(int empno);
	String updateLeaveDao(Leave1 update);
	
	

}
