
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Persons List</title>
</head>
<body>
	<form action="/MavenProject/menu/loginMenu.jsp">
		<button  class="myButton" type="submit">Back</button>
	</form>


	<form action="/MavenProject/abms/addPerson.jsp" class="roles">
		<button class="myButton" type="submit">Add Person</button>
	</form>
	<h1>Persons List</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Person Name</th>
			<th>Person Surname</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${allPersons}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.surname}" /></td>

				<td><a class="roles" href="/MavenProject/abms/modifyPerson?id=${item.id}">Edit</a>
					<a class="roles" href="/MavenProject/abms/deletePerson?id=${item.id}">Delete</a></td>
		</c:forEach>
	</table>
	
	<c:choose>
		<c:when test="${sessionScope.role.equals('admin')}">
			<script type="text/javascript">
				var elements = document.getElementsByClassName('roles');
				for (i = 0; i < elements.length; i++)
					elements[i].style.visibility = 'visible';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				var elements = document.getElementsByClassName('roles');
				for (i = 0; i < elements.length; i++)
					elements[i].style.visibility = 'hidden';
			</script>

		</c:otherwise>
	</c:choose>

</body>
</html>