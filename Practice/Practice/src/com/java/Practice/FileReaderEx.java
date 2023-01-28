package com.java.Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("D:/Java_Training/Java_Training/Practice/Practice/src/com/java/Practice/Hello.java");
			int ch;
			while((ch=fr.read()) != -1)
			{
				System.out.print((char)ch);
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
