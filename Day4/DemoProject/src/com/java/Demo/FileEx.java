package com.java.Demo;

import java.io.File;

public class FileEx {
	public static void main(String[] args) {
		File f1 = new File("D:/Java_Training/Day4/DemoProject/src/com/java/Demo/DateExs.java");
		System.out.println("Name is  "+ f1.getName());
		System.out.println("Parent is "+ f1.getParent());
		System.out.println("path is "+ f1.getPath());
	}
}
