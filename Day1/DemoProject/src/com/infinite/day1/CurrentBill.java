package com.infinite.day1;

public class CurrentBill {
	public void calculate(int units)
	{
		double rate, bill = 0;
		if(units < 90)
		{
			rate = 1;
			bill += units * rate;
		}
		if(units >= 90)
		{
			rate = 1;
			bill += 90*rate;
			rate = 1.5;
			if(units - 150 >= 0)
			{
				bill += (rate*60);
			}
			else
			{
				bill += (rate * (units - 90));
			}
			
		}
		if(units > 150)
		{
			rate = 2;
			
			if(units - 200 > 0)
			{
				bill += rate * 50; 
			}
			else
			{
				bill += (rate * (units - 150));
			}
			if(units > 200)
			{
				rate = 2.5;
				if(units - 240 > 0)
				{
					bill += rate * 40;
				}
				else
				{
					bill += (rate * (units - 200));
				}
			}
			if(units > 240)
			{
				rate = 3;
				bill += ((units - 240)*rate);
			}
		}
		    System.out.println(bill);
		
	}
	
	public static void main(String[] args) {
		new CurrentBill().calculate(241);
		int p = 90+90+100+100+3;
		System.out.println(p);
				
	}
}
