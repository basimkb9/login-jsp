<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Student Registration</title>
</head>
<body>

	<c:choose>
        <c:when test="${param['registration-success'] == true}">
            <p style="color:green">Registration was successful! <br>You may now Login to the Portal!</p>
            <form action="login.jsp" method="post">
                <input type="submit" value="Login">
            </form>
        </c:when>
        
        <c:when test="${param['registration-succes'] == false}">
            <p style="color:darkred">An error occurred, please try again.</p>
            <form action="registration" method="post">
                <input type="text" name="firstname" placeholder="Enter firstname">
                <input type="text" name="lastname" placeholder="Enter lastname">
                <input type="text" name="username" placeholder="Enter username">
                <input type="email" name="email" placeholder="Enter email address">
                <input type="password" name="password" placeholder="Enter password">
                <input type="text" name="address" placeholder="Enter address">
                <input type="submit" value="Register">    
            </form>
        </c:when>
        
        <c:otherwise>
            <form action="registration" method="post">
                <input type="text" name="firstname" placeholder="Enter firstname">
                <input type="text" name="lastname" placeholder="Enter lastname">
                <input type="text" name="username" placeholder="Enter username">
                <input type="email" name="email" placeholder="Enter email address">
                <input type="password" name="password" placeholder="Enter password">
                <input type="text" name="address" placeholder="Enter address">
                <input type="submit" value="Register">    
            </form>
        </c:otherwise>
    </c:choose>

</body>
</html>
