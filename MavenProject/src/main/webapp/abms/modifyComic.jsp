
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<title>Modify Comic</title>
</head>
<body>
	<form action="/MavenProject/listComics">
		<button class="myButton" type="submit">Back</button>
	</form>

	<h1>Comics to be modified</h1>

		
	<form action="modifyComic" method="POST">


		<label>Comic id</label>
		<input type="text" name="id" value="${comic.id}" readonly="readonly">
		<br/>

		
		<label>Comic Name</label>
		<input type="text" name="name" value="${comic.name}" required maxlength="45">
		<br/>
		
		
		<label>Comic Type</label>
		<input type="text" name="type" value="${comic.type}" required maxlength="45">
		<br/>
		
		<label>Comic Copys</label>
		<input type="number" name="copys" value="${comic.copys}" required min="0">
		<br/>
		
		<input type="submit" value="Submit">
		
	</form>
	






</body>
</html>