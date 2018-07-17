<%@page import="welldev.io.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<form action="InsertProduct" method="post">
		<input type="hidden" name = "product_id" value="<% Product product= (Product) request.getAttribute("product"); out.print(product.getId()); %>">
		<input type="hidden" value="1" name = "edit">
		<label>Name</label>
		<input type="text" name="product_name" value="<%= product.getName() %>" required="required"><br><br>
		
		<label>Quantity</label>
		<input type="number" name="product_quantity" value="<%= product.getQuantity() %>" required="required" min="0"><br><br>
		<label>Price</label>
		<input type="number" name="product_price" value="<%= product.getPrice() %>" required="required" min="0"><br><br>
		<input type="submit">
	</form>
</body>
</html>