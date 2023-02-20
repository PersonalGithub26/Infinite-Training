package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.ejb.CalculationBeanRemoteRemote;

/**
 * Servlet implementation class CalcServlet
 */
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstNo = Integer.parseInt(request.getParameter("firstNo"));
		int secondNo = Integer.parseInt(request.getParameter("secondNo"));
		try {
			CalculationBeanRemoteRemote remote = (CalculationBeanRemoteRemote) new InitialContext().lookup("CalculationBeanRemote/remote");
			PrintWriter out = response.getWriter();
			out.println("Sum is  "  +remote.sum(firstNo, secondNo) + "<Br/>");
			out.println("Sub is  " +remote.sub(firstNo, secondNo) + "<Br/>");
			out.println("Result is  " +remote.mult(firstNo, secondNo) + "<br/>");
			
		} catch (NamingException e) {
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
