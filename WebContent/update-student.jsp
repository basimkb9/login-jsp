<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.dao.StudentDAO, com.modal.Student" %>
<%
	Long id = Long.parseLong(request.getParameter("id"));
	StudentDAO dao = new StudentDAO();
	Student student = dao.getById(id);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student Info</title>
</head>
<body>

	<form action="update-student" method="post">
        <input type="hidden" name="id" value="<%= student.getId() %>">
        <label>First Name:</label>
        <input type="text" name="firstname" value="<%= student.getFirstname() %>"><br>
        <label>Last Name:</label>
        <input type="text" name="lastname" value="<%= student.getLastname() %>"><br>
        <label>Username:</label>
        <input type="text" name="username" value="<%= student.getUsername() %>"><br>
        <label>Email:</label>
        <input type="email" name="email" value="<%= student.getEmail() %>"><br>
        <label>Password:</label>
        <input type="password" name="password" value="<%= student.getPassword() %>"><br>
        <label>Address:</label>
        <input type="text" name="address" value="<%= student.getAddress() %>"><br>
        <input type="submit" value="Update Student">
    </form>

</body>
</html>