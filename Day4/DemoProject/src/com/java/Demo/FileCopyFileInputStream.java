package com.java.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyFileInputStream {
	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/DateExs.java");
			FileOutputStream fout = new FileOutputStream("D:/Files/filecopy.txt");
			
			int ch;
			while((ch=fin.read()) != -1)
			{
				fout.write((char)ch);
			}
			System.out.println("** File copied**");
			fin.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
