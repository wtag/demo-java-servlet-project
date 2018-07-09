<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateproduct" method="post" align="center">
		<h1>Edit Product</h1>
		Name: <input type="text" value="<%= request.getAttribute("name") %>"
			name="ename" style="margin-top: 20px;"><br> Quantity: <input
			type="text" value="<%= request.getAttribute("quantity") %>"
			name="equantity" style="margin-top: 20px;"><br> Price:
		<input type="text" value="<%= request.getAttribute("price") %>"
			name="eprice" style="margin-top: 20px;"><br> <input
			type="hidden" value="<%= request.getAttribute("pid") %>" name="eid"
			style="margin-top: 20px;"><br> <input type="submit"
			style="margin-top: 20px;" style="margin-top:20px;">



	</form>
</body>
</html>