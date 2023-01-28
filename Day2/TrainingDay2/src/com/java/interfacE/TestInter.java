package com.java.interfacE;

public class TestInter implements IOne1,Itwo1,IThree {

	@Override
	public void show() {
		IOne1.super.show();
		Itwo1.super.show();
		IThree.super.show();
	}

		public static void main(String[] args) {
			new TestInter().show();
		}
	
	
	
	

}
