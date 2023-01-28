package com.java.jdk8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class SortEmployByStreams {
	
	public static void main(String[] args) {
		
		List<ForEachMethod> employList = new ArrayList<ForEachMethod>();
		employList.add(new ForEachMethod(1, "Chandu", 735));
		employList.add(new ForEachMethod(1, "ajay", 765));
		employList.add(new ForEachMethod(1, "srinivas", 7635));
		employList.add(new ForEachMethod(1, "srikanth", 7635));
		employList.add(new ForEachMethod(1, "pavan", 7501));
		
		Collections.sort(employList, (e1,e2) -> {
			return e1.getName().compareToIgnoreCase(e2.getName());
		});
		
		System.out.println("Sorted data ");
		employList.forEach(x -> {
			System.out.println(x);
		});
		
		Collections.sort(employList, (e1, e2) -> {
			return (int) (e1.getBasic() - e2.getBasic());
		});
		
		System.out.println("Sorted by basic ");
		employList.forEach(x -> {
			System.out.println(x);
		});
		
		double sumOfBasic = employList.stream().mapToDouble(ForEachMethod::getBasic).sum();
		OptionalDouble Average = employList.stream().mapToDouble(ForEachMethod::getBasic).average();
		
		System.out.println("Sum of total basic is : "+sumOfBasic);
		System.out.println("Average is :" + sumOfBasic/employList.size());
		System.out.println("Average with streams : "+Average);
		
	}

}
