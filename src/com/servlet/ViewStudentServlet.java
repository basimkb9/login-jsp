package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.StudentDAO;
import com.modal.Student;

public class ViewStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		List<Student> students = studentDAO.getAll();
        request.setAttribute("students", students);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?view-students=true");
		rd.forward(request, response);
	}
}
