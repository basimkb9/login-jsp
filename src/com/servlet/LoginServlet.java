package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
//	https://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	}

}
