
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<head>
<title>Java Academy 2</title>
</head>
<body>

	<form action="/MavenProject/listLoans">
		<button class="myButton" type="submit">Back</button>
	</form>

	<h2>New Comic Information</h2>

	<form action="addLoan" method="POST">
		<label>Person</label> 
		<select name="person">
			<c:forEach items="${allPersons}" var="personValue">
				<option value="${personValue.id}">${personValue.name} - ${personValue.surname}</option>
			</c:forEach>
		</select> 
		
		<label>Comic</label> 
		<select name="comic">
			<c:forEach items="${allComics}" var="comicValue">
				<option value="${comicValue.id}">${comicValue.name}</option>
			</c:forEach>
		</select> 
		
		<br /> <input class="myButton" type="submit" value="Submit">
	</form>



</body>
</html>