package com.ejb.trans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

 
/**
 * Session Bean implementation class ManageEmployeeBean
 */
@Stateful
@Remote(EmployeeRemote.class)
public class ManageEmployeeBean implements EmployeeRemote {
	
	static EmployDAO eDao;
	
	static
	{
		eDao= new EmployDAO();
	}
 
    @PersistenceContext(unitName = "EmpMgmtPU")
    private EntityManager entityManager;
 
    public ManageEmployeeBean() {
 
    }
 
    public boolean addEmployee(Employee employee) {
    	
        entityManager.persist(employee);
        return true;
    }

	@Override
	public Employee searchEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public String deleteEmployee(int id) {
		Employee employee = searchEmployee(id);
		if(employee != null)
		{
			entityManager.remove(employee);
			return "Emploee record deleted";
		}
		// TODO Auto-generated method stub
		return "Employee record not founnd";
	}

	@Override
	public List<Employee> showEmploy() {
		Query query =  entityManager.createQuery("Select e from Employee e");
		
		return (List<Employee>)query.getResultList();
	}

	@Override
	public String updateEmploy(Employee employee) {
		Employee employee2 = searchEmployee(employee.getId());
		if(employee2 != null)
		{
			entityManager.merge(employee);
			return "Employee updated";
		}
		return "Employee Not Found";
	}
 
}


