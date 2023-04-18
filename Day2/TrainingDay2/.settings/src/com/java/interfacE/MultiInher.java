package com.java.interfacE;

public class MultiInher implements  IOne, ITwo{

	@Override
	public void sream() {
		System.out.println("Stream is Ece");
	}

	@Override
	public void name() {
		System.out.println("Name is Chandu");
	}
	public static void main(String[] args) {
		MultiInher m = new MultiInher();
		m.name();
		m.sream();
	}

}
