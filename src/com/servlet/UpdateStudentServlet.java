package com.servlet;

import java.io.IOException;

import javax.servlet.http.*;

import com.dao.StudentDAO;
import com.modal.Student;

public class UpdateStudentServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student student = new Student();
        
		student.setId(Long.parseLong(request.getParameter("id")));
        student.setFirstname(request.getParameter("firstname"));
        student.setLastname(request.getParameter("lastname"));
        student.setUsername(request.getParameter("username"));
        student.setEmail(request.getParameter("email"));
        student.setPassword(request.getParameter("password"));
        student.setAddress(request.getParameter("address"));
        
        StudentDAO studentDAO = new StudentDAO();
        boolean registrationSuccess = studentDAO.updateStudent(student);

        if (registrationSuccess) {
            response.sendRedirect("view-students");
        } else {
            response.sendRedirect("view-students");
        }
	}

}
