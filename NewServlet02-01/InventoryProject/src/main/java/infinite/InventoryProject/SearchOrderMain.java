package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchOrderMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String OrderId;
		System.out.println("Enter order id");
		OrderId = sc.next();
		OrdersDAO dao= new OrdersDaoImp();
		try {
			Orders order = dao.searchOrder(OrderId);
			if(order != null)
			{
				System.out.println(order);
			}
			else
			{
				System.out.println("order not fount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	}


