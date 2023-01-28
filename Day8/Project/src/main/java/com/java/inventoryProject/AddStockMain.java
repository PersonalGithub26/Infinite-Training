package com.java.inventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

public class AddStockMain {
	
	public static void main(String[] args) {
		StockDAO dao = new StockDaoImpl();
		Stock stock = new Stock();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Name");
		stock.setItemName(sc.next());
		System.out.println("Enter Item Price");
		stock.setPrice(sc.nextDouble());
		System.out.println("Enter Quantity Avail");
		stock.setQuantityAvail(sc.nextInt());
		try {
			System.out.println(dao.addStock(stock));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
