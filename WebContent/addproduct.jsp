<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addproduct" method="post" align="center">

     <h1>Add Product </h1> 
		Name:     <input type = "text" placeholder="name" name = "name" style="margin-top:20px;"required ><br>
		Quantity: <input type = "number"placeholder="quantity" name = "quantity" style="margin-top:20px;" required><br>
		Price: <input type = "number" placeholder="price" name = "price" style="margin-top:20px;" required ><br>
		
		<input type = "submit" style="margin-top:20px;" style="margin-top:20px;" >
		Edit or delete product <a href="dashboard" >Dashboard</a> 
		
		    
               
			
	</form>
</body>
</html>