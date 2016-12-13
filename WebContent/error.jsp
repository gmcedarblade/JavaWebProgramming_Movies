<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: Error Page</title>
	<meta name="description" content="This is a JSP error page to send users to via the RequestDispatcher when the application encounters an error.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
	<div class="hero-unit">
		<h1>Error</h1>	
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<p>${error}</p>
	</div>	
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>