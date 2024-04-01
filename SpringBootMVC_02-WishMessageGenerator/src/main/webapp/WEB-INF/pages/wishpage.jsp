<%@ page language="java"
	     contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Spring Boot MVC</title>
</head>
<body>
	<h1 align="center" style="color: red">Result page</h1>
	<hr color="blue">
	<h2>Date and time :: ${dateAndTime}</h2>
	<h2>Wish message :: ${message}</h2>
	<hr color="blue">
	<h2 align="center"><a href="home">Go to home</a></h2>
	<hr color="blue">
	<h2 align="center"><a href="example1">GET Type request</a></h2>
	<hr color="blue">
	<form action="example2" method="post">
		<input type="submit" value="POST type request">
	</form>
</body>
</html>