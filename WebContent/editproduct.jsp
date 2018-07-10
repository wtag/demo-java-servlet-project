<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="welldevdemocontroller.io.EditProduct" %>
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
 <form action="editproduct" method="post">
   <input type="hidden" name="pid" value="<%=request.getParameter("productid")%>" >
   Product Name: <input type="text" name="upname" value="<%=request.getParameter("pname")%>" required="required"><br/>
   <br><br/>
   Price: <input type="number" min="0" name="uprice" value="<%=request.getParameter("price")%>" required="required"><br/>
   <br><br/>
   Quantity: <input type="number" min= "0" name="uquantity" value="<%=request.getParameter("quantity")%>" required="required"><br/>  
  	<br><br/>
  	<input type="submit">
  </form>
  </div>
</body>

</html>