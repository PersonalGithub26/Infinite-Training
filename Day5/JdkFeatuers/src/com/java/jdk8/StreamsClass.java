package com.java.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsClass {
	
	public static void main(String[] args) {
		
		List<ForEachMethod> employList = new ArrayList<ForEachMethod>();
		employList.add(new ForEachMethod(1, "Chandu", 735));
		employList.add(new ForEachMethod(1, "ajay", 765));
		employList.add(new ForEachMethod(1, "srinivas", 7635));
		employList.add(new ForEachMethod(1, "srikanth", 7635));
		employList.add(new ForEachMethod(1, "pavan", 7501));
		// using labda to filter data
		Stream<ForEachMethod> filtered_List = employList.stream().filter(p -> p.getBasic() > 7500);
		System.out.println("Filtered data");
		filtered_List.forEach(x -> {
			System.out.println(x);
		});
		
	}

}
