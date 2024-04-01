<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><tiles:insertAttribute name="title"/></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="container container-fluid pt-3">

	<div class="col-12 text-bg-success">
		<tiles:insertAttribute name="header"/>
	</div>
	<div class="row">
		<div class="col-4 text-bg-primary p-3">
			<tiles:insertAttribute name="menu"/>
		</div>
		<div class="vr"></div>
		<div class="col-8 text-bg-info p-3">
			<tiles:insertAttribute name="body"/>
		</div>
	</div>
	<div class="col-12 text-bg-success justify-content-center text-white p-3">
		<tiles:insertAttribute name="footer"/>
	</div>

</body>
</html>