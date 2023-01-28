package com.java.Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo1 {
	Set names = new LinkedHashSet();
			{
				names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");names.add("Chandu");
				names.add("Srinivas");
				names.add("Akhila");
				System.out.println("Names are   ");
				
				for (Object object : names) {
					System.out.println(object);
				}
			}

}
