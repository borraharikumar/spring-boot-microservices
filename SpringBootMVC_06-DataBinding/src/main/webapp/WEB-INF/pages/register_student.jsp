<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Data binding</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Student registration</h1>
	<hr color="blue"><br><br>
	<!-- <form action="register" method="post"> -->
	<form method="post">
		<table style="align-self: center; background: aqua;">
			<tr>
				<td>Roll number</td>
				<td><input type="text" name="roll"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="department"></td>
			</tr>
			<tr>
				<td>CGPA</td>
				<td><input type="text" name="cgpa"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>