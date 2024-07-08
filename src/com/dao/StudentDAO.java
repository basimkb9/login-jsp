package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modal.Student;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/collegedb?useSSL=false&useLocalSessionState=true";
	static Connection con;
	
	//Student table fields to use in result set
	private static final String ID = "id";
	private static final String USERNAME = "username";
	private static final String FIRSTNAME = "firstname";
	private static final String LASTNAME = "lastname";
	private static final String EMAIL = "email";
	private static final String ADDRESS = "address";
	
	
	// custom queries
    private static final String SQL_OBTAIN_STUDENT = "SELECT * FROM student WHERE username = ? AND password = ?";
    private static final String SQL_INSERT_NEW_STUDENT = "INSERT INTO student(firstname, lastname, username, password, address, email)"
    		+ "values(?,?,?,?,?,?)";
    private static final String SQL_GET_ALL_STUDENTS = "SELECT * FROM student";
    private static final String SQL_UPDATE_STUDENT = "UPDATE student SET username = ?, "
            + "firstname = ?, "
            + "lastname = ?, "
            + "email = ?, "
            + "address = ? "
            + "WHERE id = ?";
	private static final String SQL_GET_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
	private static final String SQL_DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";	
    
    
	private Connection getConnection() {
		try {
            Class.forName("com.mysql.jdbc.Driver");

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
	
	public boolean authenticateUser(Student user) {
		boolean isValid = false;
		Connection con = getConnection();
		
		if (con == null) {
            System.out.println("Unable to establish a database connection.");
            return false;
        }
        
        try {
        	PreparedStatement ps = con.prepareStatement(SQL_OBTAIN_STUDENT);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                isValid = true; 
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
	
	public boolean addStudent(Student student) {
		Connection con = getConnection();
		int affectedRows = 0;
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT_NEW_STUDENT);
			ps.setString(1,student.getFirstname());
			ps.setString(2,student.getLastname());
			ps.setString(3,student.getUsername());
			ps.setString(4,student.getPassword());
			ps.setString(5,student.getAddress());
			ps.setString(6,student.getEmail());
			
			affectedRows = ps.executeUpdate();
			
			if(affectedRows >= 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Student> getAll() {
		Connection con = getConnection();
		List<Student> students = new ArrayList();
		try {
			PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_STUDENTS);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getLong(ID));
				s.setUsername(rs.getString(USERNAME));
				s.setFirstname(rs.getString(FIRSTNAME));
				s.setLastname(rs.getString(LASTNAME));
				s.setEmail(rs.getString(EMAIL));
				s.setAddress(rs.getString(ADDRESS));
				
				students.add(s);
			}
			
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}

	public boolean updateStudent(Student student) {
		Connection con = getConnection();
		int updatedRows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_UPDATE_STUDENT);
			ps.setString(1, student.getUsername());
			ps.setString(2, student.getFirstname());
			ps.setString(3, student.getLastname());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getAddress());
			ps.setLong(6, student.getId());
			
			updatedRows = ps.executeUpdate();
			
			if(updatedRows > 0){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteById(Long id) {
		Connection con = getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(SQL_DELETE_STUDENT_BY_ID);
			ps.setLong(1, id);
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows >= 1) {
				return true;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Student getById(Long id) {
		Connection con = getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(SQL_GET_STUDENT_BY_ID);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Student student = new Student();
				
				student.setId(rs.getLong(ID));
				student.setUsername(rs.getString(USERNAME));
				student.setFirstname(rs.getString(FIRSTNAME));
				student.setLastname(rs.getString(LASTNAME));
				student.setEmail(rs.getString(EMAIL));
				student.setAddress(rs.getString(ADDRESS));
				
				return student;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
