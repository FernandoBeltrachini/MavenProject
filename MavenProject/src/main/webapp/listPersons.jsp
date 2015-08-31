
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Persons List</title>
</head>
<body>
	<form action="/MavenProject/menu/loginMenu.jsp">
		<button type="submit">Back</button>
	</form>


	<form action="/MavenProject/abms/addPerson.jsp">
		<button type="submit">Add Person</button>
	</form>
	<h1>Persons List</h1>
	<table>
		<c:forEach items="${allPersons}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.surname}" /></td>

				<td><a href="/MavenProject/abms/modifyPerson?id=${item.id}">Edit</a>
					<a href="/MavenProject/abms/deletePerson?id=${item.id}">Delete</a></td>
		</c:forEach>
	</table>

</body>
</html>