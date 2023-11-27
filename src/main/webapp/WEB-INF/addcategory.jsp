<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Category</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Category</h1>
		<p><a href="/home">Home</a></p>
		<form:form action="/categories/create" modelAttribute="category" method="post">
			<form:label path="name" class="form-label">Name:</form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" type="text" class="form-control"/>
			<input type="Submit" value="Submit" class="btn btn-success my-2" />
		</form:form>		
	</div>
</body>
</html>