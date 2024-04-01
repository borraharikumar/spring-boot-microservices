<%@ page language="java"
		 contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"
    	 isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Rendering simple values</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Passing simple values from Controller class to View component</h1>
	<hr color="blue">
	<table>
		<tr><td>Roll number</td><td> :: ${ roll }</td></tr>
		<tr><td>Name</td><td> :: ${ name }</td></tr>
		<tr><td>Department</td><td> :: ${ department }</td></tr>
	</table>
</body>
</html>