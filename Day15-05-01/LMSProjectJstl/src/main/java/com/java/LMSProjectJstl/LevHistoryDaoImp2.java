package com.java.LMSProjectJstl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LevHistoryDaoImp2 implements levHistoryDAO{

	static levHistoryDAO dao;
	static StringBuilder sb;
	Connection connection;
	PreparedStatement pst;

	static {
		dao=new LevHistoryDaoImp();
		sb = new StringBuilder();
	}
	//prasanna.trainer@gmail.com


	public boolean checkOverlap(levHistory lev) throws Exception {
		connection = ConnectionHelper.getConnection();
		String sql = "SELECT * FROM LEAVE_HISTORY WHERE EMP_ID=? AND ((LEAVE_START_DATE BETWEEN ? AND ?) OR (LEAVE_END_DATE BETWEEN ? AND ?))";
		pst = connection.prepareStatement(sql);
		pst.setInt(1, lev.getEmpId());
		pst.setDate(2, new java.sql.Date(lev.getStDate().getTime()));
		pst.setDate(3, new java.sql.Date(lev.getEndDate().getTime()));
		pst.setDate(4, new java.sql.Date(lev.getStDate().getTime()));
		pst.setDate(5, new java.sql.Date(lev.getEndDate().getTime()));
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean manager(int empId) throws SQLException, ClassNotFoundException {

		boolean b = false;
		connection=ConnectionHelper.getConnection();
		String cmd = "SELECT EMP_MANAGER_ID FROM EMPLOYEE WHERE EMP_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			int m = rs.getInt("EMP_MANAGER_ID");
			if(m == 0)
			{
				b = true;
			}
		}

		return b;

	}


	public boolean doValid(levHistory levHistory) throws Exception
	{
		boolean isValid=true;
		if(levHistory.getStDate() != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, -1);
			String yestarday = sdf.format(c.getTime());

			if(levHistory.getStDate().equals(sdf.parse(yestarday)))
			{
				sb.append("Leave start date cannot be yesterday date..,");
				isValid=false;
			}
			if(levHistory.getEndDate().equals(sdf.parse(yestarday)))
			{
				sb.append("Leave End Date cannot be Yesterday date...,");
				isValid=false;
			}
			if(levHistory.getEndDate().before(levHistory.getStDate()))
			{
				sb.append("leave Start date cannot be greater than levave end date.....");
				isValid=false;
			}

		}
		return isValid;
	}


	@Override
	public String ApplyLeave(levHistory lev) throws Exception,LeaveExceptionCls {
		System.out.println(lev.getStDate());
		System.out.println(lev.getEndDate());
		long days = lev.getEndDate().getTime()-lev.getStDate().getTime();
		int Days = (int) (days / (1000 * 60 * 60 * 24)+1);

		lev.setNoOfDays(Days);
		if(doValid(lev) == false)
		{
			throw new LeaveExceptionCls(sb.toString());
		}
		System.out.println(lev);
		if (checkOverlap(lev)) {
			throw new LeaveExceptionCls("You have already applied for leave within these dates. Please choose different dates.");
		}
		lev.setLeaveTyp(leaveTyp.EL);
		lev.setStatus(levStatus.PENDING);
		Employ employ = new Employ();
		connection = ConnectionHelper.getConnection();
		String sql = "INSERT INTO LEAVE_HISTORY (LEAVE_NO_OF_DAYS, LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE,"
				+ " LEAVE_STATUS, LEAVE_REASON, EMP_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
		pst = connection.prepareStatement(sql);
		pst.setInt(1, Days);
		pst.setDate(2, lev.getStDate());
		pst.setDate(3, lev.getEndDate());
		pst.setString(4, lev.getLeaveTyp().toString());
		pst.setString(5, lev.getStatus().toString());
		pst.setString(6, lev.getLevReason());
		pst.setInt(7, lev.getEmpId());
		pst.executeUpdate();

		if(manager(lev.getEmpId()))
		{
			sql = "update leave_history set leave_status='APPROVED' where emp_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,lev.getEmpId());
			pst.executeUpdate();
		}

		sql = "UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BAL = EMP_AVAIL_LEAVE_BAL - ? WHERE EMP_ID = ?";
		pst = connection.prepareStatement(sql);
		pst.setInt(1, Days);
		pst.setInt(2, lev.getEmpId());
		pst.executeUpdate();
		return "Leave added successfully";
	}
	
	public int getEmpId() throws ClassNotFoundException, SQLException
	{
		connection = ConnectionHelper.getConnection();
		String cmd = "Select EMP_ID from EMPLOYEE";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		int t =0;
		if(rs.next())
		{
			t=rs.getInt("EMP_ID");
		}
		return t;
	}
	
	
	public java.sql.Date convertDate(String date) throws java.text.ParseException{
		if(date == "")
		{
			date="2023-01-19";
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate=sdf.parse(date);
		System.out.println(sdate);
		return new java.sql.Date(sdate.getTime());

	}




	public List<levHistory> pendingLeaves(int empId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where emp_id="
				+ "any(select emp_id from employee where EMP_MANAGER_ID =?) and Leave_status='PENDING'";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		List<levHistory> list = new ArrayList<levHistory>();
		levHistory leaveHistory = null;
		while(rs.next()) {
			leaveHistory = new levHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpId(rs.getInt("EMP_ID"));
			leaveHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setLevMngCmts(rs.getString("LEAVE_MNGR_COMMENTS"));
			leaveHistory.setStDate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeaveTyp(leaveTyp.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setStatus(levStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLevReason(rs.getString("LEAVE_REASON"));
			list.add(leaveHistory);
		}
		return list;
	}




	public List<levHistory> searchLeaveHistory(int empId) throws ClassNotFoundException, SQLException
	{
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from leave_history where EMP_ID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		List<levHistory> leaveList1=new ArrayList<levHistory>();
		levHistory levHistory = null;
		while(rs.next())
		{
			levHistory = new levHistory();
			levHistory.setEmpId(rs.getInt("EMP_ID"));
			levHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			levHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			levHistory.setLevMngCmts(rs.getString("LEAVE_MNGR_COMMENTS"));
			levHistory.setStDate(rs.getDate("LEAVE_START_DATE"));
			levHistory.setEndDate(rs.getDate("LEAVE_END_DATE"));
			levHistory.setLeaveTyp(leaveTyp.valueOf(rs.getString("LEAVE_TYPE")));
			levHistory.setStatus(levStatus.valueOf(rs.getString("LEAVE_STATUS")));
			levHistory.setLevReason(rs.getString("LEAVE_REASON"));
			leaveList1.add(levHistory);
		}
		connection.close();
		pst.close();
		return leaveList1;
	}
	public levHistory searchLeaveHistory2(int empId) throws ClassNotFoundException, SQLException
	{
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from leave_history where EMP_ID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		levHistory levHistory = null;
		while(rs.next())
		{
			levHistory = new levHistory();
			levHistory.setEmpId(rs.getInt("EMP_ID"));
			levHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			levHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			levHistory.setLevMngCmts(rs.getString("LEAVE_MNGR_COMMENTS"));
			levHistory.setStDate(rs.getDate("LEAVE_START_DATE"));
			levHistory.setEndDate(rs.getDate("LEAVE_END_DATE"));
			levHistory.setLeaveTyp(leaveTyp.valueOf(rs.getString("LEAVE_TYPE")));
			levHistory.setStatus(levStatus.valueOf(rs.getString("LEAVE_STATUS")));
			levHistory.setLevReason(rs.getString("LEAVE_REASON"));
		}
		connection.close();
		pst.close();
		return levHistory;
	}

	public levHistory searchLeave(int levId) throws ClassNotFoundException, SQLException
	{
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from leave_history where LEAVE_ID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, levId);
		ResultSet rs = pst.executeQuery();
		levHistory levHistory = null;
		while(rs.next())
		{
			levHistory = new levHistory();
			levHistory.setEmpId(rs.getInt("EMP_ID"));
			levHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			levHistory.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			levHistory.setLevMngCmts(rs.getString("LEAVE_MNGR_COMMENTS"));
			levHistory.setStDate(rs.getDate("LEAVE_START_DATE"));
			levHistory.setEndDate(rs.getDate("LEAVE_END_DATE"));
			levHistory.setLeaveTyp(leaveTyp.valueOf(rs.getString("LEAVE_TYPE")));
			levHistory.setStatus(levStatus.valueOf(rs.getString("LEAVE_STATUS")));
			levHistory.setLevReason(rs.getString("LEAVE_REASON"));
		}
		connection.close();
		pst.close();
		return levHistory;
	}

	public String approvDeny(int leaveId, String status, String mgrComments) {
		levHistory leaveHistory = searchLeave(leaveId);
		EmployDAO dao=new EmployDaoImp();
		if (status.equals("APPROVED")) {
			String cmd = "update leave_history set LEAVE_STATUS='APPROVED', LEAVE_MNGR_COMMENTS=? WHERE LEAVE_ID=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, mgrComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			return "Leave Approved...";
		} else {
			String cmd = "update leave_history set LEAVE_STATUS='DENIED', LEAVE_MNGR_COMMENTS=? WHERE LEAVE_ID=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, mgrComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			cmd = "Update Employee set EMP_AVAIL_LEAVE_BAL=EMP_AVAIL_LEAVE_BAL+? where EMP_ID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, leaveHistory.getNoOfDays());
			pst.setInt(2, leaveHistory.getEmpId());
			pst.executeUpdate();
			return "Leave Rejected...Balance Updated...";
		}
	}

}





	



	    





