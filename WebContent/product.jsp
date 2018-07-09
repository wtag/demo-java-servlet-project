<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="welldevdemocontroller.io.Login"%>
<%@page import="welldevdemocontroller.io.Products"%>


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
  	<a href="/DemoProjectServlet/addproduct.jsp">Add Product</a><br>
  	<a href="/DemoProjectServlet/updatepass.jsp">Update Password</a><br>
  	<a href="/DemoProjectServlet/Logout">Log Out</a><br>
  	<br></br>
  	
  	<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "demo";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center">List of Products</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
</tr>
<tr>
<td><b>Product id</b></td>
<td><b>Product Name</b></td>
<td><b>Price</b></td>
<td><b>Quantity</b></td>
<td><b>Options</b></td>
</tr>

<%
try{ 
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
statement=connection.createStatement();
String sql ="SELECT * FROM product";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr >
<td><%=resultSet.getString("productid") %></td>
<td><%=resultSet.getString("Name") %></td>
<td><%=resultSet.getString("Price") %></td>
<td><%=resultSet.getString("Quantity") %></td>
<td><a href="/DemoProjectServlet/editproduct.jsp?productid=<%=resultSet.getString("productid")%>&pname=<%=resultSet.getString("Name")%>&price=<%=resultSet.getString("Price")%>&quantity=<%=resultSet.getString("Quantity")%>">Edit</a>

<a href="/DemoProjectServlet/DeleteProduct?productid=<%=resultSet.getString("productid")%>">Delete</a></td>
</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

</div>
</body>
</html>