
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<head>
<title>Loan List</title>
</head>
<body>
	<form action="/MavenProject/menu/loginMenu.jsp">
		<button type="submit">Back</button>
	</form>



	<form action="/MavenProject/abms/addLoan" class="roles">
		<button class="myButton" type="submit">Add Loan</button>
	</form>
	<h1>Loans List</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Person Name</th>
			<th>Person SurName</th>
			<th>Comic ID</th>
			<th>Comic Type</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${allLoans}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.person.name}" /></td>
				<td><c:out value="${item.person.surname}" /></td>
				<td><c:out value="${item.comic.name}" /></td>
				<td><c:out value="${item.comic.type}" /></td>
				<td>
<%-- 				<a href="/MavenProject/abms/modifyLoan?id=${item.id}">Edit</a> --%>
					<a class="roles" href="/MavenProject/abms/deleteLoan?id=${item.id}">Delete</a></td>
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