
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<head>
<title>Comics List</title>
</head>
<body>
	<form action="/MavenProject/backListComic">
		<button class="myButton" type="submit">Back</button>
	</form>
	<h1>SOMETHING WENT WRONG</h1>


	<label>You've got an error:</label>
	<br />
	<c:out value="${error}" />
	<br />

</body>
</html>