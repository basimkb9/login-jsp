package com.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDAO;
import com.modal.Student;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		
		StudentDAO studentDAO = new StudentDAO();
		
		if (studentDAO.authenticateUser(student)) {
	            request.setAttribute("username", username);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	            dispatcher.forward(request, response);
	    }
		else {
			response.sendRedirect("login.jsp?invalid-user=true");
		}
	}

}
