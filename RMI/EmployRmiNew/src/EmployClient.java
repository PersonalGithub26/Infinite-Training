import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class EmployClient {

	public static void main(String[] args) {
		
		try {
			EmployDAO obj = (EmployDAO) Naming.lookup("localhost");
			List<Employ> list = obj.showEmployeeDao();
			
			for (Employ employ : list) {
				System.out.println(employ);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
