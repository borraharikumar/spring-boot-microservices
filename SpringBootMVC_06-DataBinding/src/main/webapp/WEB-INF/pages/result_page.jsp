<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data binding</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Student registration status</h1>
	<hr color="blue"><br><br>
	<table style="align-self: center; background: aqua;">
		<tr>
			<td>Roll number</td>
			<td> :: ${ student.roll }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td> :: ${ student.name }</td>
		</tr>
		<tr>
			<td>Department</td>
			<td> :: ${ student.department }</td>
		</tr>
		<tr>
			<td>CGPA</td>
			<td> :: ${ student.cgpa }</td>
		</tr>
	</table>
</body>
</html>