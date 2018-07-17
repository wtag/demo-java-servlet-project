<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<% 
		String msg = (String) request.getAttribute("msg");
		if(msg!=null){
			out.println(msg+"<a href='login.jsp' style = 'margin-left:10px;'>Log In</a>");
		}
	%>
	<form action="UpdatePassword" method="post">
		<input type="text" name="change" required="required">
		<input type="submit" value="Change Password">
	</form>
</body>
</html>