package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author gcedarblade
 *
 */
public class DirectorPredicate implements Predicate<Movie> {

	final String director;
	
	public DirectorPredicate(final String director) {
		this.director = director;
	}
	
	@Override
	public boolean apply(Movie movie) {
		return movie.getDirector().equalsIgnoreCase(director);
	}

}
