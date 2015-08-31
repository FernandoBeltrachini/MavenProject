<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Academy 2</title>
</head>
<body>
	<form action="/MavenProject/listComics">
		<button type="submit">Back</button>
	</form>
	
	<h2>New Comic Information</h2>
	
	
	
	<form action="addComic" method="POST">
		<label>Comic Name</label>
		<input type="text" name="name" required maxlength="45">
		<br/>
		
		
		<label>Comic Type</label>
		<input type="text" name="type" required maxlength="45">
		<br/>
		
		<label>Comic Copys</label>
		<input type="number" name="copys" required min="0">
		<br/>
		<input type="submit" value="Submit">
		
	</form>
	


</body>
</html>