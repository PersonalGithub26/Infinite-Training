package com.java.inventoryProject;

import java.sql.SQLException;
import java.util.List;

public interface StockDAO 
{
	String addStock(Stock stock) throws ClassNotFoundException, SQLException;
	Stock searchStock(String stockId) throws ClassNotFoundException, SQLException;
	List<Stock> showStock() throws ClassNotFoundException, SQLException;
}
