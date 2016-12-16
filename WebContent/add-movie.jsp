<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: Add New Movie</title>
	<meta name="description" content="This is a JSP that uses a form to add a new Movie object to the database.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
	<div class="hero-unit">
		<h1>Add Movie</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<form action="addMovie" method="post">
			<div class="form-group">
				<label for="title"><strong>Title:</strong></label>
				<input name="title">
				
				<label for="runTime"><strong>Run Time in minutes:</strong></label>
				<input name="runTime">
				
				<label for="director"><strong>Director:</strong></label>
				<input name="director">
				
				<input class="btn btn-primary btn-lg" type="submit" value="Add Movie">
			</div>
		</form>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>