package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowDaoMain {
	
		public static void showStockMain() throws ClassNotFoundException, SQLException
		{
			StockDAO dao= new StockDaoImp(); 
			StockDaoImp dao1 = new StockDaoImp();
			List<Stock> list = new ArrayList<Stock>();
			
			list.addAll(dao1.showStock());
			for (Stock stock : list) {
				System.out.println(stock);
			}
			
		}
		public static void main(String[] args) {
			try {
				showStockMain();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}





