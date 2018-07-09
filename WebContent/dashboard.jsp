
<%@page import="welldev.io.model.ProductList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="addproduct" method="post" style="margin-top:30px; text-align: center;">
		<input type="submit" value="Add Product">
		<a href="<% if(session.getAttribute("un").toString().isEmpty()){
			out.println("login.jsp");
		}else{
			out.println("changepass.jsp");
		} %>">Change Password</a>
		<a href="logout">Log Out</a>
	</form>
	
	<div class = "container">
		<h3>List of Products</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
				
					<%
						ArrayList<ProductList>pl = new ArrayList<>();
						pl = (ArrayList) request.getAttribute("product_list");
						if(!pl.isEmpty()){
							for(int i=0;i<pl.size();i++){
								
								out.println("<tr><td id = 'pid'>"+pl.get(i).getId()+"</td><td>"+pl.get(i).getName()+"</td>"+"<td>"+pl.get(i).getQuantity()+"</td>"+"<td>"+pl.get(i).getPrice()+"</td><td><a href = 'editproduct?pid="+pl.get(i).getId()+"' style='margin-right: 20px;'>Edit</a><a href = 'deleteproduct?pid="+pl.get(i).getId()+"'>Delete</a></td></tr>");
							}
						}else{
							out.println("<tr><td colspan='5' align='center'>No Data To Show</td></tr>");
						}

					%>
				
			<tbody>
			</tbody>
		</table>
	</div>
	
</body>
<style>
	a{
		margin-right:20px;
	}
</style>
</html>

