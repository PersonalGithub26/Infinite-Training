

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
//		ResourceBundle rb = ResourceBundle.getBundle("db");
//		String driver = rb.getString("driver");
//		String url = rb.getString("url");
//		String user = rb.getString("user");
//		String pwd = rb.getString("password");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite","root","india@123");
		return con;
		
	}

}
