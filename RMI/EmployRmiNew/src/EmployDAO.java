import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface EmployDAO extends Remote{

	List<Employ> showEmployeeDao() throws ClassNotFoundException, SQLException, RemoteException;

}
