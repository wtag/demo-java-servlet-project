<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<div align="center">
<br></br>
<br></br>
<h2 align="center">Login</h2>
 <form action="Login" method="post">
  	Username: <input type="text" name="username" required="required"><br/>
  	<br><br/>
  	Password: <input type="password" name="password" required="required"><br/>
  	<br><br/>
  	<input type="submit" value="login"/><br>
  	<br><br/>
  	<a href="/HibernateProject/SignIn">Sign Up</a><br>
  	
  </form>
</div>
</body>
</html>