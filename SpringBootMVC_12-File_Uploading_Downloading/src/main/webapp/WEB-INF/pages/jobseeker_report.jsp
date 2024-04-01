<%@page language="java" 
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Job seeker report</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body class="container">

	<h1>Job seeker report</h1>
	<hr>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Applicant ID</th>
				<th>Name</th>
				<th>Mobile no.</th>
				<th>Email</th>
				<th>Date of birth</th>
				<th>Qualification</th>
				<th>Resume</th>
				<th>Photo</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ !empty jobSeekerList }">
					<c:forEach var="applicant" items="${ jobSeekerList }">
						<tr>
							<td>${ applicant.id }</td>
							<td>${ applicant.name }</td>
							<td>${ applicant.mobile }</td>
							<td>${ applicant.email }</td>
							<td>${ applicant.dob }</td>
							<td>${ applicant.qualification }</td>
							<td><a href="download?id=${applicant.id}&type=resume"><button class="btn btn-info">Download</button></a></td>
							<td><a href="download?id=${applicant.id}&type=photo"><button class="btn btn-info">Download</button></a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning">
						<h1>No data found...!</h1>
					</div>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<hr>
	<div class="col-sm-3" align="right">
		<h2><a href="./"><button class="btn-success">Go to home</button></a></h2>
	</div>
	<div class="col-sm-6"></div>
	<div class="col-sm-3" align="left">
		<h2><a href="applicants-report"><button class="btn-info">Applicants report</button></a></h2>
	</div>

</body>

</html>
