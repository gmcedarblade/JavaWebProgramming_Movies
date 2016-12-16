<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: Movie Search</title>
	<meta name="description" content="This is a JSP that uses a form to search.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<form action="Search" method="post">
			<div class="form-group">
				<label for="title"><strong>Search by Title:</strong></label>
				<input name="title">
				<input name="searchType" type="hidden" value="title">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
 			</div>
 		</form>
 		<form action="Search" method="post">
 			<div class="form-group">
				<label for="runTime"><strong>Search by Run Time in minutes:</strong></label>
				<input name="runTime">
				<input name="searchType" type="hidden" value="runTime">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
 			</div>
 		</form>
 		<form action="Search" method="post">
 			<div class="form-group">
				<label for="director"><strong>Search by Director:</strong></label>
				<input name="director">
				<input name="searchType" type="hidden" value="director">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
 			</div>
 		</form>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>