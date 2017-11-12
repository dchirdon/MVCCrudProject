<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles.css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Card Data</title>
</head>
<body>

<!-- <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
  <div class="card-header">Enter data about your credit/debit card information</div>
  <div class="card-body"> -->
    <%-- <form:form action="addItem.do" method="post" modelAttribute="item">

 Type: <form:input path="type"/><form:errors path="type"/><br>
 Value: <form:input path="value"/><form:errors path="value"/><br>
 Name:	<form:input path="name"/><form:errors path="name"/><br> 
<input class="btn btn-success" type="submit" value="Add"/>
</form:form>
  --%>



<h3>Enter your credit/debit card information</h3>

<form:form action="addItem.do" method="post" modelAttribute="item">

 Type: <form:input path="type"/><form:errors path="type"/><br>
 Value: <form:input path="value"/><form:errors path="value"/><br>
 Name:	<form:input path="name"/><form:errors path="name"/><br> 
<input class="btn btn-success" type="submit" value="Add"/>
</form:form>

<p>
<a href="home.do">Home</a>
</p>

</body>
</html>