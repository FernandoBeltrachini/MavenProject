
<html>
<head>
<title>Add Person</title>
</head>
<body>

<form action="/MavenProject/listPersons">
		<button type="submit">Back</button>
	</form>

	<h2>New Person Information</h2>
	
	<form action="addPerson" method="POST">
		<label>Person Name</label>
		<input type="text" name="name" required maxlength="45">
		<br/>
		
		
		<label>Person Surname</label>
		<input type="text" name="type" required maxlength="45">
		<br/>
		
		<input type="submit" value="Submit">
		
	</form>
	


</body>
</html>