package com.java.Practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("D:/Java_Training/Java_Training/Practice/Practice/src/com/java/Practice/Hello.java");
			FileWriter fw = new FileWriter("D:/Copy/FileReadAndWrite.txt");
			int ch;
			while((ch=fr.read()) != -1)
					{
						fw.write((char)ch);
					}
			System.out.println("File Write Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
