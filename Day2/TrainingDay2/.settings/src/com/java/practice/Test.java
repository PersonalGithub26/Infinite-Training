package com.java.practice;

public class Test implements One,Two,Three{
	public static void main(String[] args) {
		Test t = new Test();
		t.name();
	}

	@Override
	public void name() {
		One.super.name();
		Two.super.name();
		Three.super.name();
		
	}

}
