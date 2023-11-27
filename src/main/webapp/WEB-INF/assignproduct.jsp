<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Category Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${ category.name }"/></h1>
		<p><a href="/home">Home</a></p>
		<hr />
		<h4>Products</h4>
		<ul>
			<c:forEach var="product" items="${ category.products }">
				<li><c:out value="${ product.name }"/></li>
			</c:forEach>
		</ul>
		<hr />
		<h4>Add Product:</h4>
		<form action="/category/${category.id}/assignproduct" method="post">
			<input type="hidden" name="_method" value="put"/>
			<label name="name">Add Product</label>
			<select name="id">
				<c:forEach var="product" items="${ products }">
					<option value="${product.id}"><c:out value="${ product.name }"/></option>
				</c:forEach>
			</select>
			<input type="Submit" value="Add" class="btn btn-success my-2"/>
		</form>
	</div>
</body>
</html>