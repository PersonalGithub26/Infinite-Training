package com.java.Collections;

import java.util.Scanner;

public class Scan1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.nextLine();
		System.out.println(name);
		sc.nextLine();
		System.out.println("Number");
		int n = sc.nextInt();
		System.out.println(n);
	}

}
