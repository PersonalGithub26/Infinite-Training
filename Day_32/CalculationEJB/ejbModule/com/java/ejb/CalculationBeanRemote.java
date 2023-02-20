package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculationBeanRemote
 */
@Stateless
@Remote(CalculationBeanRemoteRemote.class)
public class CalculationBeanRemote implements CalculationBeanRemoteRemote {
    /**
     * Default constructor. 
     */
    public CalculationBeanRemote() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sum(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int mult(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

}
