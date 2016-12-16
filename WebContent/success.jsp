<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: Success Page</title>
	<meta name="description" content="This is a JSP success page we can send users to via the RequestDispatcher when the application encounters a success scenario.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
	<div class="hero-unit">
		<h1>Success</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<p>${success}</p>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>