package com.java.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeShow {
	
	public static void main(String[] args) 
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // this name never changes
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite",
							 "root","india@123");
			String cmd = "select * from Employ";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("Employee number: "+rs.getInt("empno"));
				System.out.println("Employ Name: "+rs.getString("name"));
				System.out.println("Department: "+rs.getString("dept"));
				System.out.println("Designantion: "+rs.getString("desig"));
				System.out.println("Basic: "+rs.getInt("basic"));
				System.out.println("---------------------------------------");
			}
		} catch (ClassNotFoundException e) {
			
	
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
