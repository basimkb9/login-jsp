package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.StudentDAO;

public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        StudentDAO studentDAO = new StudentDAO();
        if (studentDAO.deleteById(id)) {
            response.sendRedirect("index.jsp?delete-success=true");
        } else {
            response.sendRedirect("index.jsp?delete-success=false");
        }
    }
}