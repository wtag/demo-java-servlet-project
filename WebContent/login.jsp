<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
	<% 
		String msg = (String) request.getAttribute("error");
		if(msg==null){
			out.println("");
		}else{
			out.println(msg);
		}
	
	%>
	<form action="dash" method="post">
		<label>User Name </label>
		<input type="text" name = "username" style="margin-top:20px;" required="required"><br><br>
		<label>Password </label>
		<input type="password" name="password" required="required"><br><br>
		<input type="submit" value="Log In">
		<a href = "/AssignmentProject/signup">Sign Up</a>
		
	</form>
</body>
</html>