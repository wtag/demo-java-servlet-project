<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="controller.Login"%>
<%@page import="model.Product"%>
<%@page import="util.Constants"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<div align="center">

<br></br>
<% out.println(request.getAttribute("name")); %>
<br></br>
<a href=<%=Constants.PATH_PRODUCT_ADD %>>Add Product</a><br>
<a href=<%=Constants.PATH_PASSWORD_UPDATE %>>Update Password</a><br>
<a href=<%=Constants.PATH_LOGOUT %>>Log Out</a><br>
<br></br>  	

<h2 align="center">List of Products</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr></tr>
<tr>
<td><b>Product id</b></td>
<td><b>Product Name</b></td>
<td><b>Price</b></td>
<td><b>Quantity</b></td>
<td><b>Options</b></td>
</tr>

<%
List<Product> products= new ArrayList<>();
products = (ArrayList) request.getAttribute("list_of_product");

if(!products.isEmpty()){
for(int i=0;i<products.size();i++){      
%>

<tr >
<td><%=products.get(i).getProductId() %></td>
<td><%=products.get(i).getProductName() %></td>
<td><%=products.get(i).getPrice() %></td>
<td><%=products.get(i).getQuantity() %></td>
<td>
<a href="/HibernateProject/ProductEdit?productid=<%=products.get(i).getProductId() %>&product_name=<%=products.get(i).getProductName() %>&price=<%=products.get(i).getPrice() %>&quantity=<%=products.get(i).getQuantity() %>">Edit</a>
<a href="/HibernateProject/DeleteProduct?productid=<%=products.get(i).getProductId() %>">Delete</a>
</td>
</tr>

<% 
}
}
else{
out.println("<tr><td colspan='5' align='center'>No Data To Show</td></tr>");
}
 %> 
</table>
</div>
</body>
</html>