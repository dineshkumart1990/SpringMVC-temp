<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add Employee</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<form action="/employee/addEmployee" method="post">
		Employee Number : &nbsp;<input type="text" name="number"/><br/><br/>
		Employee first Name : &nbsp;<input type="text" name="fname"/><spring:message code="user.username.err"/><br/><br/>
		Employee last Name : &nbsp;<input type="text" name="lname"/><br/><br/>
		Employee Gender(M/F) : &nbsp;<input type="text" name="gender"/><br/><br/>
		DOB [YYYY-MM-DD] : &nbsp;<input type="text" name="dob"/><br/><br/>
		DOJ [YYYY-MM-DD] : &nbsp;<input type="text" name="doj"/><br/><br/>
		<input type = "submit" value="Insert Employee Details"/>
	</form>
	 <p th:text= "${Message}"/>
</body>
</html>