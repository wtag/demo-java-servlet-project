<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN UP</title>
</head>
<body>
	<form action="insertuser" method="post">
		<label>Name </label>
		<input type="text" name = "name" required="required"><br><br>
		<label>User Name </label>
		<input type="text" name = "username" required="required"><br><br>
		<label>Password </label>
		<input type="password" name="password" required="required"><br><br>
		<label>Country </label>
		<input type="text" name = "country"><br><br>
		<input type="submit" value="Sign Up">
		
	</form>
</body>
</html>