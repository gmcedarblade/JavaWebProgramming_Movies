<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty movies}">
		<p>Sorry the list of movies is empty.</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="movie" items="${movies}">
			<div class="span4">
				<h2>${movie.title}</h2>
				<p>${movie.title} is ${movie.lengthInMinutes} minutes long.
					${movie.title} is directed by ${movie.director}.
				</p>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>