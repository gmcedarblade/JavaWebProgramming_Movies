package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author gcedarblade
 *
 */
public class RunTimePredicate implements Predicate<Movie> {

	final Integer runTime;
	
	public RunTimePredicate(final Integer runTime) {
		this.runTime = runTime;
	}
	@Override
	public boolean apply(Movie movie) {
		return movie.getLengthInMinutes().equals(runTime);
	}
	
}
