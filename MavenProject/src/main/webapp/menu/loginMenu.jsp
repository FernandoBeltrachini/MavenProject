<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Login Menu</title>
</head>
<body>

	<div>
		<div style="float: left;">
			<form action="/MavenProject/listComics">
				<button class="myButton" type="submit">List Comic</button>
			</form>

		</div>
		<div style="float: left; margin-left: 10px;">
			<form action="/MavenProject/listLoans">
				<div class="roles">
					<button class="myButton" type="submit">List Loans</button>
				</div>
			</form>
		</div>
		<div style="float: left; margin-left: 10px;">
			<form name="listPersons" action="/MavenProject/listPersons">
				<div class="roles">
					<button class="myButton" type="submit">List Persons</button>
				</div>
			</form>
		</div>
		<div style="float: left; margin-left: 10px;">
			<form action="/MavenProject/logout">
				<button class="myButton" type="submit">Log Out</button>
			</form>
		</div>
	</div>
	<c:set var="a" value="sessionScope.role" />
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