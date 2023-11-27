<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Products and Categories</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Home</h1>
		<p><a href="/products/new">New Product</a></p>
		<p><a href="categories/new">New Category</a></p>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<td>Products</td><td>Categories</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="list-group">
							<c:forEach var="product" items="${ products }">
								<a href="/products/${ product.id }/assigncategories" class="list-group-item"><c:out value="${ product.name }"></c:out></a>
							</c:forEach>
						</div>
					</td>
					<td>
						<ul class="list-group">
							<c:forEach var="category" items="${ categories }">
								<a href="/categories/${ category.id }/assignproducts" class="list-group-item"><c:out value="${ category.name }"></c:out></a>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>