package com.java.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearch {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int Agentno;
		System.out.println("Enter Aent number");
		Agentno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
					 "root","india@123");
			String cmd = "Select * from Agent where AgentId = ?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1, Agentno); 
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				System.out.println("Agent name: "+rs.getString("name"));
				System.out.println("Agent city: "+rs.getString("city"));
				System.out.println("Agent Gender: "+rs.getString("Gender"));
				System.out.println("Agent MaritalStatus: "+rs.getInt("MaritalStatus"));
				System.out.println("Premiun "+rs.getDouble("Premium"));
				System.out.println("---------------------------------------");

				
			}
			else
			{
				System.out.println("****record not found****");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
