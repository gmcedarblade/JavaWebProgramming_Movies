<!DOCTYPE html>
<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<html>
<head>
	<title>Java Web Programming: Populate Database</title>
	<meta name="description" content="This is a JSP that will populate a database.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	<div class="container">
		<%
	 	
	 	try {
	 		
	 		final String filePath = session.getServletContext().getRealPath("/assets/movieSheet.xlsx");
	 		final MovieDao movieDao = new MovieDaoImpl();
	 		
	 		movieDao.populateMovieTable(filePath);
	 		%>
	 		<p>Success: database populated!</p>
	 		<%
	 		
	 	} catch (final Exception e) {
	 		
	 		e.printStackTrace();
	 		%>
	 		<p>Error: Sorry, we were unable to populate the database at this time.</p>
	 		<%
	 		
	 	}
	 	
		%>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>