package com.java.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentShow {
	
	public static void main(String[] args) {
		

		 try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // this name never changes
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
							 "root","india@123");
			String cmd = "select * from Agent";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("Agent name: "+rs.getString("name"));
				System.out.println("Agent city: "+rs.getString("city"));
				System.out.println("Agent Gender: "+rs.getString("Gender"));
				System.out.println("Agent MaritalStatus: "+rs.getInt("MaritalStatus"));
				System.out.println("Premiun "+rs.getDouble("Premium"));
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
