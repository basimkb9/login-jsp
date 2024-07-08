package com.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import com.dao.StudentDAO;
import com.modal.Student;

public class AddStudentServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student newStudent = new Student();
        
        newStudent.setFirstname(request.getParameter("firstname"));
        newStudent.setLastname(request.getParameter("lastname"));
        newStudent.setUsername(request.getParameter("username"));
        newStudent.setEmail(request.getParameter("email"));
        newStudent.setPassword(request.getParameter("password"));
        newStudent.setAddress(request.getParameter("address"));
        
        StudentDAO studentDAO = new StudentDAO();
        boolean registrationSuccess = studentDAO.addStudent(newStudent);

        if (registrationSuccess) {
            response.sendRedirect("add-student.jsp?add-student-success=true");
        } else {
            response.sendRedirect("add-student.jsp?add-student-success=false");
        }
	}
}
