package com.java.LMSProjectJstl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployDaoImp implements EmployDAO{

	Connection connection;
	PreparedStatement pst;
	List<Employ> employList;

	@Override
	public List<Employ> showEmployDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from EMPLOYEE";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		employList= new ArrayList<Employ>();
		Employ employ = null;
		while(rs.next())
		{

			employ = new Employ();
			employ.setEmpId(rs.getInt("EMP_ID"));
			employ.setName(rs.getString("EMP_NAME"));
			employ.setMailId(rs.getString("EMP_MAIL"));
			employ.setMobNo(rs.getString("EMP_MOB_NO"));
			employ.setJoinDte(rs.getDate("EMP_DT_JOIN"));
			employ.setDept(rs.getString("EMP_DEPT"));
			employ.setManager(rs.getInt("EMP_MANAGER_ID"));
			employ.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));

			employList.add(employ);

		}
		connection.close();
		pst.close();
		return employList;
	}

	@Override
	public Employ SearchEmploy(int empId) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from EMPLOYEE where EMP_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		if(rs.next())
		{
			employ = new Employ();
			employ.setEmpId(rs.getInt("EMP_ID"));
			employ.setName(rs.getString("EMP_NAME"));
			employ.setMailId(rs.getString("EMP_MAIL"));
			employ.setMobNo(rs.getString("EMP_MOB_NO"));
			employ.setJoinDte(rs.getDate("EMP_DT_JOIN"));
			employ.setDept(rs.getString("EMP_DEPT"));
			employ.setManager(rs.getInt("EMP_MANAGER_ID"));
			employ.setLeaveAvail(rs.getInt("EMP_AVAIL_LEAVE_BAL"));

		}
		connection.close();
		pst.close();
		return employ;
	}
	
	
}

