<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<h1>Comics List</h1>
	<form action="/MavenProject/abms/addComic.jsp">
		<button type="submit" >Add Comic</button>
	</form>

	<table style="border-color: red;">
		<c:forEach items="${allComics}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.type}" /></td>
				<td><c:out value="${item.copys}" /></td>
				
				<td>
					<a href="/MavenProject/abms/modifyComic?id=${item.id}" >Edit</a>
					<a href="/MavenProject/abms/deleteComic?id=${item.id}">Delete</a>
				</td>
		</c:forEach>
	</table>

</body>
</html>