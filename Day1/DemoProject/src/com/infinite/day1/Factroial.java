package com.infinite.day1;

public class Factroial {
	public void isFact(int n)
	{
		int i = 1, fact = 1;
		while(i <= n){
		 fact = fact*i;
		i++;
		}
		System.out.println(fact);
		
	}
	public static void main(String[] args) {
		int n = 5;
		new Factroial().isFact(n);
	}

}
