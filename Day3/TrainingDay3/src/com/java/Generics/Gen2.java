package com.java.Generics;

public class Gen2<T,V> {
	
	public void show(T t, T v)
	{
		System.out.println(t.getClass().getSimpleName());
		System.out.println(v.getClass().getSimpleName());
	}
}
