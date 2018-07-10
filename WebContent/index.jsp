<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="signup" method="post" align="center">
     <h1>SignUp</h1> 
   
		Name:     <input type = "text"  placeholder="name" name = "name" style="margin-top:20px;" required ><br>
		Password: <input type = "password"placeholder="password" name = "password" style="margin-top:20px;" required><br>
		UserName: <input type = "text" placeholder="username" name = "username" style="margin-top:20px;" required><br>
		Country: <input type = "text" placeholder="country" name = "country" style="margin-top:20px;" required><br>
	
		<input type = "submit" style="margin-top:20px;" >
		 If you are already register, Then Login <a href="login.jsp">Login</a>.    
               
			
	</form>
	  <c:out value="${param.message}"/>
     
</body>
</html>