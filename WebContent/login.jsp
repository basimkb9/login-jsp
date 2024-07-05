<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Student Login</title>
</head>
<body>

	<h2>Student Portal</h2>

	<c:if test="${not empty param['invalid-user']}">
		<p style="color:darkred">Invalid username/password</p>
	</c:if> 
	
	<form action="login" method="post">
		<input type="text" name="username" placeholder="Enter username">
		<input type="password" name="password" placeholder="Enter password">
		<input type="submit" value="login">
	</form>
	
	<form action="registration.jsp">
		<p>Not a registered user? Sign up now!</p>
		<input type="submit" value="register">
	</form>
</body>
</html>