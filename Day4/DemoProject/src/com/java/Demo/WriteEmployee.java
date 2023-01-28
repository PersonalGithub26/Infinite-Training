package com.java.Demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmployee {
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("D:/Files/Employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			Employee employee = new Employee(1, "Chandu", 7254);
			out.writeObject(employee);
			out.close();
			fout.close();
			System.out.println("Employe object Stored...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
