package com.java.interfacE;

public class MainInterface {
	public static void main(String[] args) {
		ITraining[] iT = new ITraining[] {
				new Pavan(),new Chandu(),new Akhil()
		};
		for (ITraining i : iT) {
				i.name();
				i.stream();
			
		}
			
			
	}

}
