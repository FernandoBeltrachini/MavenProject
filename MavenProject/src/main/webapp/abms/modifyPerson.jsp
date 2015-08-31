<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Comics List</title>
</head>
<body>
	<form action="/MavenProject/listPersons">
		<button type="submit">Back</button>
	</form>

	<h1>Person to be modified</h1>

		
	<form action="modifyPerson" method="POST">


		<label>Person id</label>
		<input type="text" name="id" value="${person.id}" readonly="readonly">
		<br/>

		
		<label>Person Name</label>
		<input type="text" name="name" value="${person.name}" maxlength="45" required maxlength="45">
		<br/>
		
		
		<label>Person Surname</label>
		<input type="text" name="surname" value="${person.surname}" required maxlength="45">
		<br/>
		
		<input type="submit" value="Submit">
		
	</form>
	






</body>
</html>