package com.jsf.Demo;

import javax.faces.bean.SessionScoped;

@javax.faces.bean.ManagedBean(name="test")
@SessionScoped
public class Test {
	
	public String sayHello()
	{
		return "Welcome to jsf programming";
	}

}
