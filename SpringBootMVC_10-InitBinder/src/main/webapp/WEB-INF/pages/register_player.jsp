<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>InitBinder</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body class="conainer">

	<h1 class="txt-danger">Player registration</h1>
	<hr>
	
	<form:form modelAttribute="player" cssClass="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name : </label>
			<div class="col-sm-8" >
				<form:input path="name" cssClass="form-control" placeholder="Enter name"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="birthPlace">Birth place : </label>
			<div class="col-sm-8" >
				<form:input path="birthPlace" cssClass="form-control" placeholder="Enter birth place"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dob">Date of birth : </label>
			<div class="col-sm-8" >
				<form:input path="dob" cssClass="form-control" type="date" placeholder="Enter date of birth"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="role">Role : </label>
			<div class="col-sm-8" >
				<form:input path="role" cssClass="form-control" placeholder="Enter role"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dod">Date of debut : </label>
			<div class="col-sm-8" >
				<form:input path="dod" cssClass="form-control" type="date" placeholder="Enter date of debut"/>
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-success">Submit</button>
    		</div>
  		</div>
	</form:form>

</body>

</html>