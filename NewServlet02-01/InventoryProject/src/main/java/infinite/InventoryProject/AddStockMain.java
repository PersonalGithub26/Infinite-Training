package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

public class AddStockMain {

	public static void main(String[] args) {
		
		Stock st =new Stock();
		Scanner sc=new Scanner(System.in);
		StockDAO dao =new StockDaoImp();
		
		
		System.out.println("enetr item name");
		st.setItemName(sc.next());
		
		System.out.println("enter price");
		st.setPrice(sc.nextDouble());
		
		System.out.println("enetr total quantity");
		st.setQuantityAvail(sc.nextInt());
		
		
		try {
			System.out.println(dao.createStock(st));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
