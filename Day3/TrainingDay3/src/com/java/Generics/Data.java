package com.java.Generics;

public class Data <T>{
	public void swap(T a, T b)
	{
		T t;
		t = a;
		a = b;
		b = t;
		System.out.println("A value is   "+a   );
		System.out.println("B value is   "+b);
	}

}
