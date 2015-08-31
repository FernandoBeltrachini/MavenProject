<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Comics List</title>
</head>
<body>
	<form action="/MavenProject/backListComic" style="float: right;">
		<button class="myButton" type="submit">Back</button>
	</form>

	<h1>Comics List</h1>
	<form action="/MavenProject/abms/addComic.jsp" class="roles" > 
		<button class="myButton" type="submit" >Add Comic</button>
	</form>

	<table style="border-color: red;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Copys</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${allComics}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.type}" /></td>
				<td><c:out value="${item.copys}" /></td>
				
				<td>
					<a class="roles" href="/MavenProject/abms/modifyComic?id=${item.id}" >Edit</a>
					<a class="roles" href="/MavenProject/abms/deleteComic?id=${item.id}">Delete</a>
				</td>
		</c:forEach>
	</table>
	

	<c:choose>
		<c:when test="${sessionScope.role.equals('admin')}" > 
			<script type="text/javascript">
				var elements = document.getElementsByClassName('roles');
				for (i = 0; i < elements .length ;i++)
					elements[i].style.visibility = 'visible';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				var elements = document.getElementsByClassName('roles');
				for (i = 0; i < elements .length ;i++)
					elements[i].style.visibility = 'hidden';
			</script>

		</c:otherwise>
	</c:choose>
</body>
</html>