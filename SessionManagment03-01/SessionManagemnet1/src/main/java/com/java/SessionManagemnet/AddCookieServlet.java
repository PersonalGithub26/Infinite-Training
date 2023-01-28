package com.java.SessionManagemnet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck1 = new Cookie("Chandu", "99");
		ck1.setMaxAge(1000*60*60*24);
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("Srinivas", "98");
		ck2.setMaxAge(1000*60*60*24);
		response.addCookie(ck2);
		
		Cookie ck3 = new Cookie("Srikanrh", "97");
		ck3.setMaxAge(1000*60*60*24);
		response.addCookie(ck3);
		
		PrintWriter out = response.getWriter();
		out.println("Cookie created Successfullyy");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
