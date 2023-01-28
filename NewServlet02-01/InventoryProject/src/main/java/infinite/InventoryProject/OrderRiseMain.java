package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class OrderRiseMain {
	
	public static void riseMain() throws ClassNotFoundException, SQLException {
		OrdersDAO dao = new OrdersDaoImp();
		Scanner sc = new Scanner(System.in);
		Orders order = new Orders();
		System.out.println("Enter StockID");
		String id = sc.next();
		System.out.println("Enter Quantity to update");
		int quty= sc.nextInt();
		order.setQtyOrd(quty);
		//stock.setQuantityAvail(quty);
		System.out.println(dao.OrdersRice(order,id));

		
	}
	
	public static void main(String[] args) {
		
		try {
			riseMain();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
