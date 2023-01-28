package infinite.InventoryProject;

import java.sql.SQLException;
import java.util.List;

public interface StockDAO {
	
		String createStock(Stock stock) throws ClassNotFoundException, SQLException;
		
		Stock searchStock(String id) throws ClassNotFoundException, SQLException;
		
		List<Stock> showStock() throws ClassNotFoundException, SQLException;
		
		//String riseStock(Stock stock,String Id) throws ClassNotFoundException, SQLException;

	}



