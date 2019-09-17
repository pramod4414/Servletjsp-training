<%@page import="com.bv.handler.*"%>
<%@page import="java.util.List"%>
<%@page import="com.bv.model.*"%>
<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
 <%
 	
 List<Products> ulist = ProductDBHandler.getAllProducts();
 	
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<h3 style="text-align: right;" ><a href="products.html" >Add products</a></h3>
	<table align="center" style="background-color: gray;color: #ffffff" >
			<%
				for(Products u : ulist){
			%>
	
			<tr style="text-align: center;">
				<td><%=u.getId() %></td>
				<td><%=u.getManufacturername() %></td>
				<td><%=u.getProductname() %></td>
				<td><%=u.getPrice() %></td>
			 <td><a href="DeleteServlet?id=<%=u.getId() %>" >Delete</a></td>
			 <td><a href="UpdateProducts.jsp?id=<%=u.getId() %>" >Update</a></td>
			</tr>
			
			<% } %>
			
		</table>
		<a href="LogoutServlet">logout</a>
</body>
</html>




