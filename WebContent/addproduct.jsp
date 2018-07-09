<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form action="insertproduct" method="post">
		<label>Name</label>
		<input type="text" name="product_name" required="required"><br><br>
		
		<label>Quantity</label>
		<input type="number" name="product_quantity" required="required" min="0"><br><br>
		<label>Price</label>
		<input type="number" name="product_price" required="required" min = "0"><br><br>
		<input type="submit">
	</form>
</body>
</html>