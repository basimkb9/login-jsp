<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Add New Student</title>
</head>
<body>

	<c:choose>
        <c:when test="${param['add-student-success'] == 'true'}">
            <p class="success">Successfully added new Student!<br>Would you like to add another?</p>
            <a href="add-student.jsp" class="button">Add Another Student</a>
            <a href="view-students" class="button">HomePage</a>
        </c:when>
        <c:otherwise>
            <c:if test="${empty param['add-student-success'] || param['add-student-success'] == 'false'}">
                <c:if test="${param['add-student-success'] == 'false'}">
                    <p class="fail">Could not add student, please try again and make sure all the fields are filled.</p>
                </c:if>
                
                <form action="add-student" method="post">
                    <label for="firstname">First name:</label>
                    <input type="text" id="firstname" name="firstname"><br>
                    <label for="lastname">Last name:</label>
                    <input type="text" id="lastname" name="lastname"><br>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username"><br>
                    <label for="email">Email Address:</label>
                    <input type="text" id="email" name="email"><br>
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address"><br>
                    <input type="submit" value="Add Student">
                </form>
            </c:if>
        </c:otherwise>
    </c:choose>
	
		
	

</body>
</html>