<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comics List</title>
</head>
<body>
	<form action="/MavenProject/index.jsp">
		<button type="submit">Back</button>
	</form>

	<h1>Comics to be modified</h1>

		
	<form action="modifyComic" method="POST">


		<label>Comic id</label>
		<input type="text" name="id" value="${comic.id}">
		<br/>

		
		<label>Comic Name</label>
		<input type="text" name="name" value="${comic.name}">
		<br/>
		
		
		<label>Comic Type</label>
		<input type="text" name="type" value="${comic.type}">
		<br/>
		
		<label>Comic Copys</label>
		<input type="number" name="copys" value="${comic.copys}">
		<br/>
		<input type="submit" value="Submit">
		
	</form>
	






</body>
</html>