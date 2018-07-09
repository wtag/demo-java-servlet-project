<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Password</title>
</head>
<body>
<div align="center">
<br></br>
    <%
    if(request.getAttribute("msg")==null)
    {
    	out.println("");
    }
    else
    out.println(request.getAttribute("msg")); %>
    <br></br>
<h2 align="center"> Update Password</h2><br/><br/>
 <form action="updatepass" method="post">
   Old Password: <input type="password" name="opass" required="required"><br/><br/><br/>
   New Password: <input type="password" name="npass" required="required"><br/><br/>  
  	<input type="submit">
  </form>
</div>

</body>
</html>