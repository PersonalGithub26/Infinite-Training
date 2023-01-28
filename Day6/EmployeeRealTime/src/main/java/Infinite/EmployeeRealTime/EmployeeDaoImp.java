package Infinite.EmployeeRealTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDAO{
	
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public List<Employee> showEmployeeDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ";
		//String cmd2 = "Select * from Employ where basic > 50000";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = null;
		while(rs.next())
		{
			employee = new Employee();
			employee.setEmpId(rs.getInt("empno"));
			employee.setName(rs.getString("name"));
			employee.setDept(rs.getNString("dept"));
			employee.setDesg(rs.getString("desig"));
			employee.setBasic(rs.getInt("basic"));
			employeeList.add(employee);
			
		}
		connection.close();
		pst.close();
		return employeeList;
	}


	@Override
	public Employee searchEmployeeDao(int empId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ where empno = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;
		if(rs.next())
		{
			employee = new Employee();
			employee.setEmpId(rs.getInt("empno"));
			employee.setName(rs.getString("name"));
			employee.setDept(rs.getNString("dept"));
			employee.setDesg(rs.getString("desig"));
			employee.setBasic(rs.getInt("basic"));
			
		}
		connection.close();
		pst.close();
		return employee;
	}


	@Override
	public String addEmployeeDao(Employee employee) throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Employ(Name,Dept,Desig,Basic) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employee.getName());
		pst.setString(2, employee.getDept());
		pst.setString(3, employee.getDesg());
		pst.setInt(4, employee.getBasic());
		pst.executeUpdate();
		connection.close();
		pst.close();
		
		return "Employee Record inserted....";
	}


	@Override
	public String updateEmployee(Employee employeeNew) throws ClassNotFoundException, SQLException {
		Employee employee = searchEmployeeDao(employeeNew.getEmpId());
		if(employee != null)
		{
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Employ set Name=?, Dept=?, Desig=?, Basic=? where Empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, employeeNew.getName());
			pst.setString(2, employeeNew.getDept());
			pst.setString(3, employeeNew.getDesg());
			pst.setInt(4, employeeNew.getBasic());
			pst.setInt(5, employeeNew.getEmpId());
			pst.executeUpdate();
			return "Employee record updated";

		}
		
		
		return "Employee not found";
	}


	@Override
	public String deleteEmployeeDao(int empId) throws ClassNotFoundException, SQLException {
		Employee employee = searchEmployeeDao(empId);
		if(employee != null)
		{
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from Employ where empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, empId);
			pst.executeUpdate();
			return "Employee record deleted";
			

		}
		return "Employe record not found...";
	}

}
