<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<form action="insertproduct" method="post">
		<input type="hidden" name = "pid" value="<%= request.getAttribute("id") %>">
		<input type="hidden" value="1" name = "edit">
		<label>Name</label>
		<input type="text" name="pname" value="<%= request.getAttribute("n") %>" required="required"><br><br>
		
		<label>Quantity</label>
		<input type="number" name="quantity" value="<%= request.getAttribute("q") %>" required="required" min="0"><br><br>
		<label>Price</label>
		<input type="number" name="price" value="<%= request.getAttribute("pp") %>" required="required" min="0"><br><br>
		<input type="submit">
	</form>
</body>
</html>