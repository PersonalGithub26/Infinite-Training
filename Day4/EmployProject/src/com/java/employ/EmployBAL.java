package com.java.employ;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class EmployBAL 
{

	static EmployDAO dao;
	static StringBuilder sb;

	static 
	{
		dao = new EmployDaoImpl();
		sb = new StringBuilder();
	}
	public String readEmployFileBal() throws ClassNotFoundException, IOException
	{
		return dao.readEmployFileDao();
	}

	public String writeEmployFilebal()

			throws FileNotFoundException, IOException{
		return dao.writeEmployFileDao();
	}

	public String addEmployBal(Employ employ) throws EmployException
	{

		if(doValid(employ)==false)
		{
			throw new EmployException(sb.toString());
		}

		return dao.addEmployeeDao(employ);
	}

	public String updateEmployBal(Employ employ) throws EmployException
	{

		if(doValid(employ)==false)
		{
			throw new EmployException(sb.toString());
		}

		return dao.updateEmployDao(employ);

	}

	public List<Employ> showEmployBal()
	{
		return dao.showEmployDao();
	}

	public Employ searchEmployBal(int empno)
	{

		return dao.searchEmployDao(empno);
	}

	public String deleteEmployBal(int empno)
	{
		return dao.deleteEmployDao(empno);
	}

	public boolean doValid(Employ employ)
	{
		boolean isValid = true;
		if(employ.getEmpNo() <= 0)
		{
			sb.append("Employee number cannot be zero or negative");
			isValid = false;
		}
		if(employ.getName().length() < 5)
		{
			sb.append("Employee name should contain min 5 chars");
			isValid = false;
		}
		if(employ.getDept().length() < 3)
		{
			sb.append("Department shoulod contains min 3 chars");
			isValid = false;
		}
		if(employ.getDesig().length() < 4)
		{
			sb.append("Designantion should contain min 4 chars");
			isValid = false;
		}
		if(employ.getBasic() < 1000 || employ.getBasic() > 90000)
		{
			sb.append("Basic should be in between 10000 and 90000");
			isValid = false;
		}



		return isValid;
	}

}
