<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	isELIgnored="false" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
    	 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Passing array and collection type values from controller class to view component</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Passing Array &amp; Collection type values from Controller class to View component</h1>
	<hr color="blue">
	<table>
		<tr><td>Name</td><td> :: ${ name }</td></tr>
		<tr><td>Favorite colors</td><td> :: ${ favColors }</td></tr>
		<tr><td>Mobile numbers</td><td> :: ${ phoneNumbers }</td></tr>
		<tr><td>Qualifications</td><td> :: ${ qualifications }</td></tr>
		<tr><td>Identity cards</td><td> :: ${ identities }</td></tr>
	</table>
	<hr color="blue">
</body>
</html>