<%@page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee report</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body class="container pt-3">
	
	<h1 class="text-danger">Employee report</h1>
	<hr>
	
	<c:choose>
		<c:when test="${ empList.hasContent() }">
			<table class="table table-striped table-responsive">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Hire-date</th>
						<th>Job</th>
						<th>Salary</th>
						<th>Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${ empList.getContent() }">
						<tr>
							<td>${ employee.id }</td>
							<td>${ employee.name }</td>
							<td>${ employee.email }</td>
							<td>${ employee.hireDate }</td>
							<td>${ employee.job }</td>
							<td>${ employee.salary }</td>
							<td>
								<a href="edit-employee?id=${employee.id}"><button class="btn btn-info">Edit</button></a> 
								<a href="fire-employee?id=${employee.id}">
									<button class="btn btn-danger" onclick="return confirm('Are you sure to fire employee with id : ${employee.id}')">Delete</button>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning" align="center">
				<strong>No records found...!</strong>
			</div>
		</c:otherwise>
	</c:choose>
	
	<p style="color: blue;" align="center">
		<c:if test="${ !empList.isFirst() }">
			<a href="employee-report?page=0">First</a>&nbsp;
		</c:if>
		<c:if test="${ empList.hasNext() }">
			<a href="employee-report?page=${ empList.getNumber()+1 }">Next</a>&nbsp;
		</c:if>
		<c:forEach var="i" begin="1" end="${ empList.getTotalPages() }" step="1">
			[<a href="employee-report?page=${ i-1 }">${ i }</a>] &nbsp;
		</c:forEach>
		<c:if test="${ empList.hasPrevious() }">
			<a href="employee-report?page=${ empList.getNumber()-1 }">Previous</a>&nbsp;
		</c:if>
		<c:if test="${ !empList.isLast() }">
			<a href="employee-report?page=${ empList.getTotalPages()-1 }">Last</a>
		</c:if>
	</p>
	
	<c:if test="${ !empty message }">
		<div class="alert alert-success" align="center">
			<strong>${ message }</strong>
		</div>
	</c:if>
	
	<div class="row">
		<div class="col-sm-3">
			<h3 align="right"><a href="hire-employee"><button class="btn-success">Hire employee</button></a></h3>
		</div>
		<div class="col-sm-6"></div>
		<div class="col-sm-3">
			<h3 align="left"><a href="./"><button class="btn-primary">Go to home</button></a></h3>
		</div>
	</div>
	
	
</body>
</html>