package com.java.employ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployDaoImpl implements EmployDAO
{
	
	static List<Employ>  employList;
	static Employ employ;
	
	static
	{
		employList=new ArrayList<Employ>();
		employ=new Employ();
	}

	@Override
	public List<Employ> showEmployDao() {
		
		return employList ;
	}

	@Override
	public String addEmployeeDao(Employ employ) {
	
		employList.add(employ);
		return "Employ has been added successfully ";
	}

	@Override
	public Employ searchEmployDao(int empno) 
	{
		Employ employfound=null;
		for (Employ employ : employList) 
		{
			if(employ.getEmpNo()==empno)
			{
				employfound=employ;
				break;
			}
		}
		return employfound;
	}

	@Override
	public String deleteEmployDao(int empno) 
	{
		Employ employfound=searchEmployDao(empno);
		if(employfound!=null)
		{
			employList.remove(employfound);
		}
		return "Employ Record not found *********";
	}

	@Override
	public String updateEmployDao(Employ employnew) 
	{
		Employ employfound=searchEmployDao(employnew.getEmpNo());
		if(employfound!=null)
		{
			for (Employ employ : employList) 
			{
				if(employ.getEmpNo()==employnew.getEmpNo())
				{
				employ.setName(employnew.getName());
				employ.setDept(employnew.getDept());
				employ.setDesig(employnew.getDesig());
				employ.setGender(employnew.getGender());
				employ.setBasic(employnew.getBasic());
				}
				break;
				
			}
			return " Employ record updated";
		}
		return "****Employ Record not found*******";
	}
	
	@Override
	public String writeEmployFileDao(Employ employ) throws IOException
	{
		FileOutputStream fout == new FileOutputStream("D:/Files/")
	}

	

	

	

	
}
