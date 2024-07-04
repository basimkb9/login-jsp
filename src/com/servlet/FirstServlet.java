package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		writer.println("FirstServlet invoked");

		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		if (i <= 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
			rd.forward(request, response);
		}
		else {
			int k = i + j;
			request.setAttribute("result", k);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("add-num");
			dispatcher.forward(request, response);
		}

	}
}
