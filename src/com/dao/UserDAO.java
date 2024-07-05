package com.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.modal.User;

public class UserDAO {
	static String URL = "";
	static Connection con;
	
	private Connection getConnection() {
		try {
            Class.forName("com.mysql.jdbc.Driver");

            URL = "jdbc:mysql://localhost:3306/collegedb";

            con = DriverManager.getConnection(URL, "sibisoft", "");

        } 
		catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } 
		catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }

        return con;
	}
	
	public boolean authenticateUser(User user) {
		boolean isValid = false;
		Connection con = getConnection();
		
		if (con == null) {
            System.out.println("Unable to establish a database connection.");
            return false;
        }
        
        String sql = "SELECT * FROM student WHERE username = ? AND password = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    isValid = true; 
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
        
		return isValid;

	}
}
