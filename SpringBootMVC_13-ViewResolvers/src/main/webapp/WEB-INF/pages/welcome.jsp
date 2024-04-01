<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>BeanNameViewResolver</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="container container-fluid">

	<br>
	<h1>BeanNameViewResolver example</h1>
	<hr>
	<br>
	<div class="container text-center">
		<a href="report?type=excel" class="col"><button class="btn btn-info rounded-1">Excel report</button></a>
		<a href="report?type=pdf" class="col"><button class="btn btn-info rounded-1">PDF report</button></a>
	</div>

</body>
</html>