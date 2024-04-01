<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Spring Boot - File uploading &amp; downloading</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body class="container">

	<br>
	<h1 class="text-danger">Register Job seeker</h1>
	<hr>
	
	<form:form cssClass="form-horizontal" modelAttribute="applicantData" enctype="multipart/form-data">
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="name">Name : </label>
			<div class="col-sm-7">
				<form:input path="name" cssClass="form-control" placeholder="Enter name here"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="mobile">Mobile : </label>
			<div class="col-sm-7">
				<form:input path="mobile" cssClass="form-control" placeholder="Enter mobile number here"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="email">Email : </label>
			<div class="col-sm-7">
				<form:input path="email" cssClass="form-control" placeholder="Enter email here"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="dob">Date of birth : </label>
			<div class="col-sm-7">
				<form:input path="dob" type="date" cssClass="form-control" placeholder="Enter email here"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="address">Address : </label>
			<div class="col-sm-7">
				<form:input path="address" cssClass="form-control" placeholder="Enter address here"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="address">Qualification : </label>
			<div class="col-sm-7">
				<form:select path="qualification" cssClass="form-control">
				<form:option value="">-- Select highest qualification --</form:option>
					<form:option value="10th class">10th class</form:option>
					<form:option value="Intermediate">Intermediate</form:option>
					<form:option value="Degree/B.tech">Degree/B.tech</form:option>
					<form:option value="PG">PG</form:option>
				</form:select>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="resume">Resume : </label>
			<div class="col-sm-7">
				<form:input path="resume" type="file" cssClass="form-control" placeholder="Upload resume"/>
			</div>
		</div>
		<div class="form-group" align="right">
			<label class="contro-label col-sm-3" for="photo">Photo : </label>
			<div class="col-sm-7">
				<form:input path="photo" type="file" cssClass="form-control" placeholder="Upload photo"/>
			</div>
		</div>
		<div class="form-group" align="right">
	    	<div class="col-sm-6" align="center">
	      		<button type="submit" class="btn btn-success">Submit</button>
	    	</div>
	    	<div class="col-sm-6" align="center">
	      		<a href="./"><button class="btn btn-info">Go back</button></a>
	    	</div>
	  	</div>
	</form:form>

</body>

</html>