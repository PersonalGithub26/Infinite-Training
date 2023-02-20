package com.cmsJsf;

public class MenuMainId {
	
	public static void main(String[] args) {
		
		MenuDaoImp imp = new MenuDaoImp();
	
		System.out.println(imp.searchByMenuDao("CHICKEN 65", 1));
	}

}
