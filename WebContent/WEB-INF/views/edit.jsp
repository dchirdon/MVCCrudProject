<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Credit Card Data</title>
</head>
<link rel="stylesheet" href="styles/styles.css">
<body>
	<h3>Enter your new card information:</h3>

	<form:form action="editItem.do" method="post"
		modelAttribute="item">

 Type: <form:input path="type" />
		<form:errors path="type" />
		<br>
 Value: <form:input path="value" />
		<form:errors path="value" />
		<br>
 Image URL:	<form:input path="imageURL" />
		<form:errors path="imageURL" />
		<br>

		<form:hidden path="id" />
		<input type="submit" value="Edit" />
	</form:form>

</body>
</html>