package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;

public class MaxAndMinBySreams {
	
	public static void main(String[] args) {
		
		List<ForEachMethod> employList = new ArrayList<ForEachMethod>();
		ForEachMethod[] arr = employList.toArray(new ForEachMethod[employList.size()]);
		
		
		employList.add(new ForEachMethod(1, "Chandu", 735));
		employList.add(new ForEachMethod(1, "ajay", 765));
		employList.add(new ForEachMethod(1, "srinivas", 7635));
		employList.add(new ForEachMethod(1, "srikanth", 7635));
		employList.add(new ForEachMethod(1, "pavan", 7501));
		
		ForEachMethod employee = employList.stream().max((m1, m2) -> 
		m1.getBasic() > m2.getBasic() ? 1 : -1).get();
		System.out.println(employee);
		
		// program to sum of all employees and average
		
		ForEachMethod employee2 = employList.stream().min((m1, m2) -> 
		m1.getBasic() < m2.getBasic() ? 1 : -1).get();
		System.out.println(employee2);
		
		
	}

}
