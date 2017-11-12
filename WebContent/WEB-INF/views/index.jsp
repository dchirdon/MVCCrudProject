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
	crossorigin="anonymous">
</head>
<link rel="stylesheet" href="styles.css/styles.css">
<body>
	<div class="container" align="center">
		<div class="row">
			<div class="col-sm">

				<h2>WELCOME TO YOUR VIRTUAL WALLET</h2>

				<form:form action="getItem.do" method="post"
					modelAttribute="itemIdForm">

					<form:input path="id" />
					<form:errors path="id" />

					<input type="submit" value="See your card information">

					<!-- <input type="number" name="giraffeId"> -->
					<!-- <input type="submit" value="Get a Giraffe"> -->
				</form:form>

				<%-- <c:if test="${not empty bestGiraffe }">
The best giraffe is: ${bestGiraffe }
</c:if> --%>
				<div class="col-sm">
					<p>
						<a href="add.do">Add a card</a>
					</p>
				</div>


				<p>
					All of your cards: <br>
					<c:forEach var="item" items="${list }">
						<a href="info.do?id=${wallet.id}">${wallet.type }</a>
						<br>
						<form method="post" action="delete.do">
							<input type="submit" value="Delete"> <input type="hidden"
								name="id" value="${item.id }">
						</form>
						<form method="post" action="edit.do">
							<input type="submit" value="Edit"> <input type="hidden"
								name="id" value="${item.id }">
						</form>
					</c:forEach>
				</p>
			</div>

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