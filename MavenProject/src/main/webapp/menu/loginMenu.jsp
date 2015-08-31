<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyles.css">
<title>Login Menu</title>
</head>
<body>


	<form action="/MavenProject/listComics">
		<button type="submit">List Comic</button>
	</form>


	<form action="/MavenProject/listLoans">
		<button type="submit">List Loans</button>
	</form>


	<form name="listPersons" action="/MavenProject/listPersons">
		<div class="roles">
			<button type="submit">List Persons</button>

		</div>
	</form>

	<form action="/MavenProject/logOut">
		<button type="submit">Log Out</button>
	</form>

	<c:choose>
		<%-- 	<c:when test="${accion.equals('admin')}" scope="session"> --%>
		<c:when test="${true}">
			<script type="text/javascript">
				document.getElementsByClassName('roles').visibility = hidden;
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				document.getElementsByClassName('roles').visibility = hidden;
			</script>

		</c:otherwise>
	</c:choose>






</body>
</html>