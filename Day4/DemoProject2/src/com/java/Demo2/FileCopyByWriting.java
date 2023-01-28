package com.java.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyByWriting {
	public static void main(String[] args) {
		File src = new File("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/FileReadEx.java");
		File tar = new File("D:/Files/Copy1.txt");
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(tar);
			int ch;
			while((ch=fr.read()) != -1)
			{
				fw.write((char) ch);
			}
			fr.close();
			fw.close();
			System.out.println("File copied successfully");
		} catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
