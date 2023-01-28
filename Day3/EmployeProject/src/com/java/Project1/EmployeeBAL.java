package com.java.Project1;

import java.util.List;

//Business Logic

public class EmployeeBAL {
	
	static EmployeeDAO dao;
	static StringBuilder sb;
	static {
		dao = new EmployeeDaoImp();
		sb = new StringBuilder();
	}
	
	public String addEmployeeBal(Employee employee) throws EmployeeException
	{
		if(doValid(employee) == false)
		{
			throw new EmployeeException(sb.toString());
		}
		return dao.addEmployeeDao(employee);
	}
	
	public List<Employee> showEmployeeBal()
	{
		return dao.showEmployeeDao();
	}
	
	public boolean doValid(Employee employee)
	{
		boolean isValid = true;
		if(employee.getEmpId() <= 0)
		{
			sb.append("Employee number cannot be zero or negative");
			isValid = false;
		}
		if(employee.getName().length() < 5)
		{
			sb.append("Employee name should contain min 5 chars");
			isValid = false;
		}
		if(employee.getDept().length() < 3)
		{
			sb.append("Department shoulod contains min 3 chars");
			isValid = false;
		}
		if(employee.getDesig().length() < 4)
		{
			sb.append("Designantion should contain min 4 chars");
			isValid = false;
		}
		if(employee.getBasic() < 1000 || employee.getBasic() > 90000)
		{
			sb.append("Basic should be in between 10000 and 90000");
			isValid = false;
		}

		
				
		return isValid;
	}
	
//	public Employee searchEmployeeBal(int id)
//	{
//		Employee em = null;
//		for(Employee e : dao.showEmployeeDao())
//		{
//			if(e.getEmpId()== id)
//			{
//				 em = e;
//			}
//		}
//		return em;
//	}
	
	public Employee searchEmployee(int empId)
	{
		return dao.searchEmployeeDao(empId);
	}
//	public String deleteEmployeeBal(int id)
//	{
//		String s = "";
//		for (Employee e : dao.showEmployeeDao()) 
//		{
//			if(e.getEmpId() == id)
//			{
//				s = dao.deleteEmployeeDao(e);
//				 break;
//			}
//		}
//		return s;
	//}
	@Override
	public String deleteEmployeeBal(Employee employee)
	{
		return dao.deleteEmployeeDao(employee);
	}
	public String updateEmployeBal(int id, String desig, double salary)
	{
		for(Employee e : dao.showEmployeeDao())
		{
			if(e.getEmpId() == id)
			{
				e.setDesig(desig);
				e.setBasic(salary);
			}
		}
		return dao.updateEmployeeListDao();
	}

}
