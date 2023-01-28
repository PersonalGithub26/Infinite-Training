package com.java.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadPractice {
	
	public static void main(String[] args) {
		
		File f = new File("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/FileReadEx.java");
		try {
			FileReader fr = new FileReader(f);
			int ch;
			try {
				while((ch=fr.read()) != -1)
				{
					System.out.print((char) ch);
					
				}
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
