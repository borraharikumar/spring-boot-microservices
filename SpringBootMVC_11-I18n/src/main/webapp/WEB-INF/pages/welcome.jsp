<%@page language="java"
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"
    	isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Internationalization</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body class="container">
	
	<h1 class="text-primary"><spring:message code="home.title"/></h1>
	<hr>
	<h2><a href="register"><spring:message code="home.registration.link"/></a></h2>
	<br><br>
	<p align="center">
		<a href="?lang=te_AP">తెలుగు</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=ta_TN">தமிழ்</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=mr_MH">मराठी</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=ma_KE">മലയാളം</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=ka_KA">ಕನ್ನಡ</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=hi_IN">हिंदी</a>&nbsp;&nbsp;&nbsp;
		<a href="?lang=en_US">English</a>
	</p>
	
</body>

</html>