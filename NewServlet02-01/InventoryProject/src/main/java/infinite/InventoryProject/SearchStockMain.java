package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchStockMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stockId;
		System.out.println("Enter Stock id");
		stockId = sc.next();
		StockDAO dao= new StockDaoImp();
		try {
			Stock stock = dao.searchStock(stockId);
			if(stock != null)
			{
				System.out.println(stock);
			}
			else
			{
				System.out.println("Stock not fount");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
