<%@page language="java"
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"
    	isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Internationalization</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body class="container">

	<h1 class="txt-info"><spring:message code="customer.reg.title" /></h1>
	<hr>
	<br>
	<form:form cssClass="form-horizonal" modelAttribute="customer">
		<div class="form-group">
			<label class="control-label col-sm-3" for="id"><spring:message code="customer.reg.id"/></label>
			<div class="col-sm-9">
				<form:input path="id" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="name"><spring:message code="customer.reg.name"/></label>
			<div class="col-sm-9">
				<form:input path="name" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="address"><spring:message code="customer.reg.address"/></label>
			<div class="col-sm-9">
				<form:input path="address" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="billAmt"><spring:message code="customer.reg.billAmt"/></label>
			<div class="col-sm-9">
				<form:input path="billAmt" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-3 col-sm-9">
      			<button type="submit" class="btn btn-default">Submit</button>
    		</div>
  		</div>
	</form:form>

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