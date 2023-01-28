package com.java.inventoryProject;

import java.sql.SQLException;

public interface OrdersDAO {
	String placeOrder(Orders od) throws ClassNotFoundException, SQLException;

}
