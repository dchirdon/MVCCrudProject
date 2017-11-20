 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Virtual Wallet</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous"/>
<link rel="stylesheet" href="styles.css/styles.css">

<%-- <%@ include file="add.jsp" %> --%>
</head>


<!-- <div class="container" color="grey">
	<h2>WELCOME TO YOUR VIRTUAL WALLET</h2>
</div> -->
<body style="font-family:script; color:lightgrey; font-size: 20px;">
	<br>
	<nav 
		class="navbar navbar-light bg-grey justify-content-between"> 
		<a style="font-family:Papyrus; color:black; font-size: 30px; font-weight: bold;" class="navbar-brand">WELCOME TO YOUR VIRTUAL WALLET</a> <form:form
		action="getItem.do" method="post" modelAttribute="itemIdForm">

		<form:input path="id" />
		<form:errors path="id" />

		<input type="submit" value="Enter card number:">

	</form:form>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="add.do">Add a new card</a></li>
	</ul>

	</nav>
	
	<%-- <form:form action="getItem.do" method="post"
		modelAttribute="itemIdForm">

		<form:input path="id" />
		<form:errors path="id" />

		<input type="submit" value="Enter card number:">

	</form:form> --%>

	<h4></h4>
	<br>
	<h4>Your cards:</h4>
	<br>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Type</th>
				<th scope="col">Bank</th>
				<th scope="col">Balance</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<%-- 		<tr>
			<th scope="row">${item.id}</th>
			<td>${item.type}</td>
			<td>${item.name}</td>
			<td></td>
		</tr> --%>
			<c:forEach var="item" items="${list }">
				<tr scope="row">
					<td><a href="info.do?id=${item.id}">${item.id } </a></td>
					<td>${item.type }</td>
					<td>${item.name }</td>
					<td>$ ${item.value }</td>

					<td>
						<form method="post" action="edit.do">
							<input class="btn btn-success" type="submit" value="Edit">
							<input type="hidden" name="id" value="${item.id }">
						</form>
					</td>
					<td>

						<form method="post" action="delete.do">
							<input class="btn btn-danger" type="submit" value="Delete">
							<input type="hidden" name="id" value="${item.id }">
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>
</body>
</html>