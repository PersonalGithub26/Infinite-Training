package infinite.InventoryProject;

import java.sql.SQLException;

public interface OrdersDAO {
	
	String placeOrder(Orders od) throws ClassNotFoundException, SQLException;
	String OrdersRice(Orders od, String id) throws ClassNotFoundException, SQLException;
	Orders searchOrder(String id) throws ClassNotFoundException, SQLException;

}
