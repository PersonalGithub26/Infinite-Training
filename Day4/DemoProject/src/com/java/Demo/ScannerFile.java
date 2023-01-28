package com.java.Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFile {
	public static void main(String[] args) {
		File f1 = new File("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/DateExs.java");
		
		try {
			Scanner sc = new Scanner(f1);
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
