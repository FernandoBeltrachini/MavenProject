<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Academy 2</title>
</head>
<body>
	<h2>New Comic Information</h2>

	<form action="addLoan" method="POST">
		<label>Person</label> 
		<select name="person">
			<c:forEach items="${allPersons}" var="personValue">
				<option value="${personValue.id}">${personValue.name} - ${personValue.surname}</option>
			</c:forEach>
		</select> 
		
		<label>Comic</label> 
		<select name="comic">
			<c:forEach items="${allComics}" var="comicValue">
				<option value="${comicValue.id}">${comicValue.name}</option>
			</c:forEach>
		</select> 
		
		<br /> <input type="submit" value="Submit">
	</form>



</body>
</html>