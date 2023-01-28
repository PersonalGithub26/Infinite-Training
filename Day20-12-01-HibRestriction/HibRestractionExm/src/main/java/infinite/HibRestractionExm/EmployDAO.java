package infinite.HibRestractionExm;

import java.util.List;

public interface EmployDAO {
	
	List<Employ> showEmployDao();
	String searchEmploy(int empno);
	String updateEmploy(Employ employ);
	String deleteEmploy(int empno);
	String insertEmploy(Employ employ);
}
