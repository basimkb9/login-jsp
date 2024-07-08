<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/style.css">
    <title>Welcome Page</title>
</head>
<body>
    <h4>Welcome, ${username}</h4>
    
    <a href="add-student.jsp" class="button">Add Student</a>
    <a href="view-students" class="button">View Students</a>
    
    <c:if test="${param['delete-students']==false}">
    	<p class="fail">Failed to delete student, please try again</p>
    </c:if>
    
    <c:if test="${param['view-students'] == true || param['delete-students'] == true}">
    	<table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Address</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstname}</td>
                    <td>${student.lastname}</td>
                    <td>${student.username}</td>
                    <td>${student.email}</td>
                    <td>${student.address}</td>
                    <td>
                        <a href="update-student.jsp?id=${student.id}" class="button">Edit</a> |
                        <a href="delete-student?id=${student.id}" class="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
</body>
</html>
