<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Java Web Programming: View All</title>
	<meta name="description" content="This is a JSP example that demonstrates how to build a dynamic website using JSPs.">
	<%@ include file="assets/include/styles.jsp" %>
</head>
<body>
<div class="container">
	
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	
	<jsp:include page="assets/include/navigation.jsp"></jsp:include>
	
	<div class="container">
	
		<jsp:include page="assets/include/movie-view.jsp"></jsp:include>
		
	</div>
	<hr>
	<%@ include file="assets/include/footer.jsp" %>
</div>
<%@ include file="assets/include/scripts.jsp" %>
</body>
</html>