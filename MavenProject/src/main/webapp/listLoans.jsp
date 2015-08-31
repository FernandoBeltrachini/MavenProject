
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Loan List</title>
</head>
<body>
	<form action="/MavenProject/menu/loginMenu.jsp">
		<button type="submit">Back</button>
	</form>



	<form action="/MavenProject/abms/addLoan">
		<button type="submit">Add Loan</button>
	</form>
	<h1>Loans List</h1>
	<table>
		<c:forEach items="${allLoans}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.person.id}" /></td>
				<td><c:out value="${item.person.name}" /></td>
				<td><c:out value="${item.person.surname}" /></td>
				<td><c:out value="${item.comic.id}" /></td>
				<td><c:out value="${item.comic.name}" /></td>

				<td>
<%-- 				<a href="/MavenProject/abms/modifyLoan?id=${item.id}">Edit</a> --%>
					<a href="/MavenProject/abms/deleteLoan?id=${item.id}">Delete</a></td>
		</c:forEach>
	</table>

</body>
</html>