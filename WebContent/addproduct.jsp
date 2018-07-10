<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Products</title>

</head>
<body>
<div align="center">
<br><br/>
<h2 align="center">Add Product</h2>
 <form action="addproduct" method="post">
   Product Name: <input type="text" name="pname" required="required"><br/>
   <br><br/>
   Price: <input type="number" min="0" name="price" required ="required"><br/>
   <br><br/>
   Quantity: <input type="number" min="0" name="quantity" required ="required"><br/>  
   <br><br/>
  	<input type="submit">
  </form>
</div>
</body>
</html>