<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hire employee</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<style type="text/css">
		span {
			color: red;
		}
	</style>
	<script type="text/javascript" src="js/validations.js"></script>
</head>
<body class="container pt-3">
	
	<h1 class="text-danger">Edit employee</h1>
	<hr>
	
	<form:form modelAttribute="employee" method="post" cssClass="form-horizontal" onsubmit="return validate(this)">
		<div class="form-group">
			<label class="control-label col-sm-2" for="id">Name : </label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" path="id" id="id"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name : </label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" path="name" id="name"/>
				<form:errors cssClass="txt txt-dander" path="name" id="nameErr"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email : </label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" path="email" id="email"/>
				<form:errors cssClass="txt txt-dander" path="email" id="emailErr"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="country">Country : </label>
			<div class="col-sm-8">
				<form:select cssClass="form-control" path="country" id="country">
					<form:options items="${ countries }"/>
				</form:select>
				<form:errors cssClass="txt txt-dander" path="country" id="countryErr"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="hireDate">Hire-date : </label>
			<div class="col-sm-8">
				<input type="date" class="form-control" name="hireDate" id="hireDate"value="${ employee.hireDate }">
				<form:errors cssClass="txt txt-dander" path="hireDate" id="hireDateErr"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="job">Job : </label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" path="job" id="job"/>
				<form:errors cssClass="txt txt-dander" path="job" id="jobErr"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="salary">Salary : </label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" path="salary" id="salary"/>
				<form:errors cssClass="txt txt-dander" path="salary" id="salaryErr"/>
			</div>
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-success">Submit</button>
    		</div>
  		</div>
  		<form:hidden path="vflag"/>
	</form:form>
	
</body>
</html>