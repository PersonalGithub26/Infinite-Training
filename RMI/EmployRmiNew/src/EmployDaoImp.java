import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDaoImp extends UnicastRemoteObject implements EmployDAO{

	protected EmployDaoImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employ> showEmployeeDao() throws ClassNotFoundException, SQLException, RemoteException{
		Connection connection = ConnectionHelper.getConnection();

		String cmd = "select * from Employ";
		//String cmd2 = "Select * from Employ where basic > 50000";
		PreparedStatement pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employ> employeeList = new ArrayList<Employ>();
		Employ employee = null;
		while(rs.next())
		{
			employee = new Employ();
			employee.setEmpId(rs.getInt("empno"));
			employee.setName(rs.getString("name"));
			employee.setDept(rs.getNString("dept"));
			employee.setDesg(rs.getString("desig"));
			employee.setBasic(rs.getInt("basic"));
			employeeList.add(employee);

		}
		connection.close();
		pst.close();
		return employeeList;
	}
}


