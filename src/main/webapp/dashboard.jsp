<%@page import="Model.Product"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="dashboard" method="post" align="center">
		<h1>Dashboard</h1>
         <h2>WelCome <%=session.getAttribute("username")%></h2>
		If you want to add product <a href="productadd">AddProduct</a>. <a
			href="updatepassword?uid=<%=session.getAttribute("userId")%>">UpdatePassword</a>.
			<a
			href="logout?username=<%=session.getAttribute("username")%>">Logout</a>.
		
			 <h2>Product List</h2>
			<div>
			<table  border="1" align="center"  style="width:50%">
			
			<%
				List<Product> products = (List<Product>) request.getAttribute("products");
				//out.print(products.get(0).getPid());
			%>
			<tr>

				<td>name</td>
				<td>price</td>
				<td>quantity</td>
				<td>Action</td>
				<%
					for (Product product : products) {
				%>
			
			<tr>

				<td><%=product.getName()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getQuantity()%></td>
				<td><a href="editproduct?id=<%=product.getProId()%>">
						Edit</a><a href="deleteproduct?id=<%=product.getProId()%>">
						Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		</div>


	</form>



</body>
</html>