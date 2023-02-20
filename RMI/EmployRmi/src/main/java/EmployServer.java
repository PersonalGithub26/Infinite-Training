import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class EmployServer {
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());
		try {
			EmployDAO obj = new EmployDaoImp();
			Naming.rebind("localhost", obj);
			System.out.println("Server is Ready...");
			System.out.println("Waiting for client Requests...");
			EmployDAO dao = new EmployDaoImp();
			List<Employ> employeeList;
			try {
				employeeList = dao.showEmployeeDao();
				for (Employ employee : employeeList) {
					System.out.println(employee);
					//EmployeeShowAllMain();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
