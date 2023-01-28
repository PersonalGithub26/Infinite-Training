package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

public class PlaceOrderMain {
	
	public static void main(String[] args) {
		

		OrdersDAO dao = new OrdersDaoImp();
		Scanner sc=new Scanner(System.in);
		
		Orders od=new Orders();
		
		System.out.println("enter stock id");
		od.setStockId(sc.next());
		
		System.out.println("enetr quantity to order");
		od.setQtyOrd(sc.nextInt());
		
		try {
			System.out.println(dao.placeOrder(od));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
