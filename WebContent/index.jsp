<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: Homework Home</title>
	<meta name="description" content="Home page for assignments in Java Web Programming.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Welcome to my Java Web Programming Homework website</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<p>In this course we learn what it is like to be a Java Web Programmer.
		We will work with our Movie spreadsheet again; this time to populate a database.</p>
		<p>If we need to populate (or re-populate) the database, <a href="populate-database.jsp">click here</a></p>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
</div>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>