package com.ejb.trans;

import java.util.List;

import javax.ejb.Remote;


 
@Remote
public interface EmployeeRemote {
    public boolean addEmployee(Employee employee);
    Employee searchEmployee(int id);
    String deleteEmployee(int id);
    List<Employee> showEmploy();
    String updateEmploy(Employee employee);
}

