package com.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDAO;
import com.modal.User;

public class LoginServlet extends HttpServlet {
//	https://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		
		if (userDao.authenticateUser(user)) {
	            request.setAttribute("username", username);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
	            dispatcher.forward(request, response);
	    }
		else {
			response.sendRedirect("login.jsp?invalid-user=true");
		}
	}

}
