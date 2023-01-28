package newInfinite.LibProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BooksDaoImp implements LibraryDAO
{
	Connection connection;
	PreparedStatement pst;

	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = EntryptPassword.getCode(libUsers.getPassWord());
		String cmd = "insert into LibUsers(UserName,Password)"+"values(?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, cmd);
		
		
	}

	@Override
	public int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
