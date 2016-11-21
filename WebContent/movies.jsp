<!DOCTYPE html>
<%@page import="edu.cvtc.web.model.Movie"%>
<%@page import="edu.cvtc.web.util.WorkbookUtility"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Java Web Programming: Movie Page</title>
	<meta name="description" content="Moive page for Moives Application assignment.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie List</h1>
	</div>
	<%@ include file="assets/include/navigation.jsp" %>
	
	<div class="container">
		<% 
		try {
			
			List<Movie> movies = new ArrayList<>();
			final String filePath = session.getServletContext().getRealPath("/assets/movieSheet.xlsx");
			final File inputFile = new File(filePath);
			movies = WorkbookUtility.retrieveMovieFromWorkbook(inputFile);

			final String sortType = request.getParameter("sort");
			
			if (null != sortType) {
				//switch casses...
			}
			
			for(final Movie movie : movies) {
				%>
				<div class="span4">
					<h2><%=movie.getTitle() %> </h2>
					<p>
						Directed by: <%=movie.getDirector() %>
						<br>Runtime: <%=movie.getLengthInMinutes() %>
					</p>
				</div>
				<%
			}
			
		} catch (final Exception e){
			
			e.printStackTrace();
			%>
			<h1>Error</h1>
			<p> Sorry, we were unable to complete your request.</p>
			<%
		}
		
		%>
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
</div>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>