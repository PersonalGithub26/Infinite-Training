package com.jsf.Demo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmployDAO {
	
	public List<Employ> showEmploy()
	{
		List<Employ> employs = new ArrayList<Employ>();
		employs.add(new Employ(1,"chandu", "java", "Developer", 54574.63));
		employs.add(new Employ(2,"srinivas", "dornet", "Developer", 52027.63));
		employs.add(new Employ(3,"Srikanth", "python", "programmer", 45087.63));
		employs.add(new Employ(4,"ajay", "Angular", "Tester", 35748.63));
		employs.add(new Employ(5,"pranay", "React", "Manager", 25454.63));
		return employs;
	}
		
	
}
