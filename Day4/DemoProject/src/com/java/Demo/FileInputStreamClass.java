package com.java.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamClass {
	
	public static void main(String[] args) {
		
		FileInputStream fin;
		try {
			fin = new FileInputStream("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/DateExs.java");
			
			int ch;
			while((ch=fin.read()) != -1)
			{
				System.out.print((char) ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
