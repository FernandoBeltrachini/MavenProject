<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Person</title>
</head>
<body>
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