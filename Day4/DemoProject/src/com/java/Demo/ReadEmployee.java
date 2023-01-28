package com.java.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadEmployee {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream fin  = new  FileInputStream("D:/Files/Employee.txt");
			ObjectInputStream out = new ObjectInputStream(fin);
			Employee employee = (Employee)out.readObject();
			System.out.println(employee);
			fin.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
