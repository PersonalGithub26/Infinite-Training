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
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
