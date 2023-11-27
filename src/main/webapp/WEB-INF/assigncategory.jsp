<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${ product.name }"/></h1>
		<p><a href="/home">Home</a></p>
		<hr />
		<h4>Categories</h4>
		<ul>
			<c:forEach var="category" items="${ product.categories }">
				<li><c:out value="${ category.name }"/></li>
			</c:forEach>
		</ul>
		<hr />
		<h4>Add Category:</h4>
		<form action="/products/${product.id}/assigncategory" method="post">
			<input type="hidden" name="_method" value="put"/>
			<label name="name">Add Category</label>
			<select name="id">
				<c:forEach var="category" items="${ categories }">
					<option value="${category.id}"><c:out value="${ category.name }"/></option>
				</c:forEach>
			</select>
			<input type="Submit" value="Add" class="btn btn-success my-2"/>
		</form>
	</div>
</body>
</html>