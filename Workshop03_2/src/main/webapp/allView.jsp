<%@page import="web.servlet.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="jumborton text-center">
		<h1>Product List</h1>
	</div>
	<table class="table table-dark table-stripe table-hover">
		<thead>
			<tr>
				<th>상품 번호</th>
				<th>상 품 명</th>
				<th>가    격</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
		<%
			ArrayList<Product> list= (ArrayList<Product>)request.getAttribute("list");
			for(Product p : list){
		%>
			<tr>
				<td><%= p.getNum() %></td>
				<td><%= p.getName() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getDetail() %></td>
			</tr>
		<%
			}
		%>		
		</tbody>
	</table>	
	<h3><a href="index.html">INDEX</a></h3>
</div>
</body>
</html>












