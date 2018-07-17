<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="controller.EditProduct" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div align="center">
<br><br/>
<h2 align="center">Edit Product</h2>
 <form action="EditProduct" method="post">
   <input type="hidden" name="product_id" value="<%=request.getParameter("productid")%>" >
   Product Name: <input type="text" name="updated_product_name" value="<%=request.getParameter("product_name")%>" required="required"><br/>
   <br><br/>
   Price: <input type="number" min="0" name="updated_product_price" value="<%=request.getParameter("price")%>" required="required"><br/>
   <br><br/>
   Quantity: <input type="number" min= "0" name="updated_product_quantity" value="<%=request.getParameter("quantity")%>" required="required"><br/>  
  	<br><br/>
  	<input type="submit">
  </form>
  </div>
</body>

</html>