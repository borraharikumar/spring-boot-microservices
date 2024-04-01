<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Passing model object data from controller to view component</title>
	</head>
<body>
	<h1 style="color: red; text-align: center;">Passing model class object data from controller to view component</h1>
	<hr color="blue">
	<h3>Product details ::</h3>
	<table>
		<tr><td>Code</td><td> :: ${ product.code }</td></tr>
		<tr><td>Name</td><td> :: ${ product.name }</td></tr>
		<tr><td>Category</td><td> :: ${ product.category }</td></tr>
		<tr><td>Price</td><td> :: ${ product.price }</td></tr>
		<tr><td>Quantity</td><td> :: ${ product.qty }</td></tr>
	</table>
</body>
</html>