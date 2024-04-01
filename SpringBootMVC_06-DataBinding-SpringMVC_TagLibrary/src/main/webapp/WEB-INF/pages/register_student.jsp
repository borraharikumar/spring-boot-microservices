<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register student</title>
</head>
<body style="align-content: center;">
	<h1 style="color: red; text-align: center;">Student registration</h1>
	<hr color="blue">
	<form:form method="post" modelAttribute="student">
		<table>
			<tr>
				<td>Roll no.</td>
				<td><form:input path="roll"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><form:input path="department"/></td>
			</tr>
			<tr>
				<td>CGPA</td>
				<td><form:input path="cgpa"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>