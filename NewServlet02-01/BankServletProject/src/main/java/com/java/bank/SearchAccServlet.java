package com.java.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAccServlet
 */
public class SearchAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountNo = Integer.parseInt(request.getParameter("accountNo"));
		BankDAO dao = new BankDaoImpl();
		PrintWriter out = response.getWriter();
		try {
			Bank bank = dao.searchAccount(accountNo);
			if(bank!=null)
			{
				out.println("account Number "+bank.getAccountNo()+"<br/>");
				out.print("Name "+bank.getFirstName()+" "+bank.getLastName());
				out.println("City "+bank.getCity());
				out.println("State "+bank.getState());
				out.println("Amount "+bank.getAmount());
				out.println("Account type"+bank.getAccountType());
				
			}
		} catch (ClassNotFoundException | SQLException e) {
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
