package com.java.servletNew;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EmployeeShowAllServlet
 */
public class EmployeeShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		
		PrintWriter out= response.getWriter();
		EmployeeDAO dao = new EmployeeDaoImp();
		try {
			List<Employee> list = dao.showEmployeeDao();
			for (Employee employee : list) {
				out.println("Employee No. "+employee.getEmpId()+"<br/>");
				out.println("Employee Name "+employee.getName()+"<br/>");
				out.println("Employee Department "+employee.getDept()+"<br/>");
				out.println("Employee Designantion "+employee.getDesg()+"<br/>");
				out.println("Employee Basic "+employee.getBasic()+"<br/><hr>");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
