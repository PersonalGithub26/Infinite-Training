package com.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.protobuf.TextFormat.ParseException;

public class LmsDaoImpl implements LmsDAO {

	Connection connection;
	PreparedStatement pst;
	static StringBuilder sb;

	static {

		sb = new StringBuilder();
	}

	@Override
	public List<Employee> showEmployee() throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();

		String cmd = "select * from employee";

		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();

		List<Employee> empList = new ArrayList<>();

		Employee emp = null;

		while (rs.next()) {

			emp = new Employee();
			emp.setEmpId(rs.getInt("emp_id"));
			emp.setEmpName(rs.getString("emp_name"));
			emp.setEmpMail(rs.getString("emp_mail"));
			emp.setEmpMobNo(rs.getString("emp_mob_no"));
			emp.setEmpDtJoin(rs.getDate("emp_dt_join"));
			emp.setEmpDept(rs.getString("emp_dept"));
			emp.setEmpManagerId(rs.getInt("emp_manager_id"));
			emp.setEmpAvailLeaveBal(rs.getInt("emp_avail_leave_bal"));

			empList.add(emp);

		}
		connection.close();
		pst.close();

		return empList;
	}

	@Override
	public Employee showOne(int id) throws ClassNotFoundException, SQLException {
		Employee emp = null;
		connection = ConnectionHelper.getConnection();

		String cmd = "select * from employee where emp_id=?";

		pst = connection.prepareStatement(cmd);
		pst.setInt(1, id);

		int managerId = 0;
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			managerId = rs.getInt("emp_manager_id");
			emp = new Employee();
			emp.setEmpId(rs.getInt("emp_id"));
			emp.setEmpName(rs.getString("emp_name"));
			emp.setEmpMail(rs.getString("emp_mail"));
			emp.setEmpMobNo(rs.getString("emp_mob_no"));
			emp.setEmpDtJoin(rs.getDate("emp_dt_join"));
			emp.setEmpDept(rs.getString("emp_dept"));
			emp.setEmpManagerId(rs.getInt("emp_manager_id"));
			emp.setEmpAvailLeaveBal(rs.getInt("emp_avail_leave_bal"));

		}
		return emp;

	}

	public Employee showManager(int manId) throws ClassNotFoundException, SQLException {
		Employee emp = null;
		connection = ConnectionHelper.getConnection();

		String cmd = "select * from employee where emp_id=?";

		pst = connection.prepareStatement(cmd);
		pst.setInt(1, manId);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			emp = new Employee();
			emp.setEmpId(rs.getInt("emp_id"));
			emp.setEmpName(rs.getString("emp_name"));
			emp.setEmpMail(rs.getString("emp_mail"));
			emp.setEmpMobNo(rs.getString("emp_mob_no"));
			emp.setEmpDtJoin(rs.getDate("emp_dt_join"));
			emp.setEmpDept(rs.getString("emp_dept"));
			emp.setEmpManagerId(rs.getInt("emp_manager_id"));
			emp.setEmpAvailLeaveBal(rs.getInt("emp_avail_leave_bal"));

		}
		return emp;

	}

	public boolean doValidation(LeaveHistory e) throws ClassNotFoundException, SQLException {
		boolean isValid = true;

		if ((e.getLeaveStartDate().before(new Date()))) {
			sb.append("leave start date cannot be yeterday");
			isValid = false;
		}
		if (e.getLeaveEndDate().before(new Date())) {
			sb.append("leave end date cannont be before today");
			isValid = false;
		}
		if (e.getLeaveEndDate().before(e.getLeaveStartDate())) {
			sb.append("leave start date cannot be greater than leave end date ");
			isValid = false;
		}
		if (e.getLeaveStartDate().after(e.getLeaveEndDate())) {

			isValid = false;
		}
		if (e.getLeaveNoOfDays() > getLeaveAvailable(e.getEmpId())) {
			isValid = false;
		}
		if (checkLeaveOverlap(e)) {
			isValid = false;
		}

		return isValid;

	}

	public long count(Date start, Date end) throws ParseException, java.text.ParseException {

		int offDays = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		LocalDate localDatefirst = Instant.ofEpochMilli(start.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate localDatelast = Instant.ofEpochMilli(end.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

		Calendar c1 = Calendar.getInstance();
		c1.setTime(start);
		int w1 = c1.get(Calendar.DAY_OF_WEEK);
		c1.add(Calendar.DAY_OF_WEEK, -w1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(end);
		int w2 = c2.get(Calendar.DAY_OF_WEEK);
		c2.add(Calendar.DAY_OF_WEEK, -w2);

		// end Saturday to start Saturday
		long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		long daysWithoutWeekendDays = days - (days * 2 / 7);

		// Adjust days to add on (w2) and days to subtract (w1) so that Saturday
		// and Sunday are not included
		if (w1 == Calendar.SUNDAY && w2 != Calendar.SATURDAY) {
			w1 = Calendar.MONDAY;
		} else if (w1 == Calendar.SATURDAY && w2 != Calendar.SUNDAY) {
			w1 = Calendar.FRIDAY;
		}

		if (w2 == Calendar.SUNDAY) {
			w2 = Calendar.MONDAY;
		} else if (w2 == Calendar.SATURDAY) {
			w2 = Calendar.FRIDAY;
		}

		String[] holidays = new String[] {

				"28-12-2022", "26-01-2023"

		};

		for (LocalDate date = localDatefirst; date.isBefore(localDatelast); date = date.plusDays(1)) {

			for (int i = 0; i < holidays.length; i++) {
				Date temp = sdf.parse(holidays[i]);

				LocalDate localDateTemp = Instant.ofEpochMilli(temp.getTime()).atZone(ZoneId.systemDefault())
						.toLocalDate();

				if (date.equals(localDateTemp)) {
					offDays++;
				}
			}
		}

		return daysWithoutWeekendDays - w1 + w2 - offDays;

	}

	public int getNoofDays(LeaveHistory e) throws ParseException, java.text.ParseException {

		long off = count(e.getLeaveStartDate(), e.getLeaveEndDate());

		return (int) off + 1;
	}

	public int getLeaveAvailable(int empId) throws ClassNotFoundException, SQLException {
		Employee emp = showOne(empId);

		return emp.getEmpAvailLeaveBal();

	}

	public String leaveApply(LeaveHistory leave)
			throws ClassNotFoundException, SQLException, ParseException, java.text.ParseException {
		int days=getNoofDays(leave);

		if (doValidation(leave)==false) {
			return "";
		}

			connection = ConnectionHelper.getConnection();

			String sql = "insert into leave_history(LEAVE_NO_OF_DAYS,LEAVE_MNGR_COMMENTS,EMP_ID,LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_TYPE,LEAVE_REASON,LEAVE_STATUS)"
					+ "values(?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setInt(1, getNoofDays(leave));
			pst.setString(2, leave.getLeaveManagerComments());
			pst.setInt(3, leave.getEmpId());
			pst.setDate(4, leave.getLeaveStartDate());
			pst.setDate(5, leave.getLeaveEndDate());
			pst.setString(6, leave.getLeaveType().name());
			pst.setString(7, leave.getLeaveReason());
			pst.setString(8, LeaveStatus.PENDING.name());
			pst.executeUpdate();
			
			if(isManager(leave.getEmpId())){
				sql="update leave_history set leave_status='APPROVED' where emp_id=?";
				pst = connection.prepareStatement(sql);
				pst.setInt(1,leave.getEmpId());
				pst.executeUpdate();
			}
			
			sql = "UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BAL = EMP_AVAIL_LEAVE_BAL - ? WHERE EMP_ID = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,days);
			pst.setInt(2,(leave.getEmpId()));
			pst.executeUpdate();
			
			
			return "leave apllied succes";
		
			
	

	}

	public boolean isManager(int id) throws ClassNotFoundException, SQLException {

		boolean var = false;
		connection = ConnectionHelper.getConnection();

		String sql = "select emp_manager_id from employee where emp_id=? ";

		pst = connection.prepareStatement(sql);
		pst.setInt(1, id);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			int man = rs.getInt("emp_manager_id");
			if (man == 0) {

				var = true;
			}
		}

		return var;
	}

	public List<LeaveHistory> showLeave(int empid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();

		String cmd = "select * from leave_history where emp_id=?";

		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empid);
		ResultSet rs = pst.executeQuery();

		List<LeaveHistory> leaveList = new ArrayList<>();

		LeaveHistory l = null;
		while (rs.next()) {

			l = new LeaveHistory();
			l.setLeaveId(rs.getInt("leave_id"));
			l.setLeaveNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			l.setLeaveManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
			l.setEmpId(rs.getInt("emp_id"));
			l.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			l.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			l.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			l.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			l.setLeaveReason(rs.getString("LEAVE_REASON"));

			leaveList.add(l);

		}
		connection.close();
		pst.close();

		return leaveList;

	}

	public boolean checkLeaveOverlap(LeaveHistory leave) throws ClassNotFoundException, SQLException {
		boolean valid = false;

		List<LeaveHistory> leaveList = showLeave(leave.getEmpId());
		if (leaveList != null) {

			for (LeaveHistory leaveHistory : leaveList) {

				if (leave.getLeaveStartDate().before(leaveHistory.getLeaveEndDate())) {
					valid = true;

				}

			}
		} else {
			valid = false;
		}
		return valid;

	}

	public java.sql.Date convertDate(String date) throws java.text.ParseException {
		if (date == "") {
			date = "2023-01-07";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse(date);
		System.out.println(sdate);

		return new java.sql.Date(sdate.getTime());

	}
	
	
	
	public List<LeaveHistory> pendingLeaves(int manId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where emp_id=any(select emp_id from employee where EMP_MANAGER_ID =?) and Leave_status='PENDING'";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, manId);
		ResultSet rs = pst.executeQuery();
		List<LeaveHistory> leaveList = new ArrayList<LeaveHistory>();
		LeaveHistory leaveHistory = null;
		while(rs.next()) {
			leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveId(rs.getInt("LEAVE_ID"));
			leaveHistory.setEmpId(rs.getInt("EMP_ID"));
			leaveHistory.setLeaveNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			leaveHistory.setLeaveManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
			leaveHistory.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leaveHistory.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leaveHistory.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leaveHistory.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leaveHistory.setLeaveReason(rs.getString("LEAVE_REASON"));
			leaveList.add(leaveHistory);
		}
		return leaveList;
	}

}
