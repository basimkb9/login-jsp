package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNumberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println("AddNumberServlet invoked");
		
		int result = (int) request.getAttribute("result");
		
		PrintWriter out = response.getWriter();
		out.println("Result is: " + (result*result));
		
	}
}
