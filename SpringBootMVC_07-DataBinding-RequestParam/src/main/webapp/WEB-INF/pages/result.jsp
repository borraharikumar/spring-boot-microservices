<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>@RequestParam data binding</title>
</head>
<body>
	<h1 style="color: red;text-align: center;">Data binding - @RequestParam</h1>
	<hr color="blue">
	<h2 style="color: maroon;">Request parameters :</h2>
	<h3 style="color: teal;"> ${ param.roll } <br> ${ param.name } <br> ${ param.add }</h3>
</body>
</html>