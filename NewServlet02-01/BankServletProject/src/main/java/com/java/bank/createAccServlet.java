package com.java.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createAccServlet
 */
public class createAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankDAO dao = new BankDaoImpl();
		Bank bank = new Bank();
		bank.setFirstName(request.getParameter("firstName"));
		bank.setLastName(request.getParameter("lastName"));
		bank.setCity(request.getParameter("city"));
		bank.setState(request.getParameter("state"));
		bank.setAmount(Integer.parseInt(request.getParameter("amount")));
		bank.setCheqFacil(request.getParameter("cheqFacility"));
		bank.setAccountType(request.getParameter("accountType"));
		bank.setCheqFacil(request.getParameter("cheqFacility"));
		
		
		PrintWriter out =response.getWriter();
		try {
			out.println(dao.createAccount(bank));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
