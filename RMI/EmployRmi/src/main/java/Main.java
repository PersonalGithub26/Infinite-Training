import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EmployDAO dao;
		try {
			dao = new EmployDaoImp();
			List<Employ> employeeList; 
			employeeList = dao.showEmployeeDao();
			for (Employ employee : employeeList) {
				System.out.println(employee);
				//EmployeeShowAllMain();
			}
		} catch (RemoteException e) {
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
