<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN UP</title>
</head>
<body>
<div align="center">
<br><br/>
<h2 align="center">Sign Up</h2>
 <form action="signup" method="post">
    Name: <input type="text" name="name" required="required"><br/>
    <br><br/>
  	Username: <input type="text" name="username" required="required"><br/>
  	<br><br/>
  	Password: <input type="password" name="password" required="required"><br/>
  	<br><br/>
  	Country: <input type="text" name="country" required="required"><br/>
  	<br><br/>
  	<input type="submit"><br><br/>
  	<a href="/DemoProjectServlet/login.jsp">Go Back </a><br>
  </form>
</div>
</body>
</html>