<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login Menu</title>
</head>
<body>


	<form action="/MavenProject/listComics">
		<button type="submit">List Comic</button>
	</form>


	<form action="/MavenProject/listLoans">
		<div class="roles" >
			<button type="submit">List Loans</button>
		</div>
	</form>

	<form name="listPersons" action="/MavenProject/listPersons">
		<div class="roles" >
			<button type="submit">List Persons</button>
		</div>
	</form>

	<form action="/MavenProject/logout">
		<button type="submit">Log Out</button>
	</form>

	<c:set var="a" value="sessionScope.role"/>
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