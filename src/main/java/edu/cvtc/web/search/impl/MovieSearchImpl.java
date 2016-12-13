package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predicates.DirectorPredicate;
import edu.cvtc.web.predicates.RunTimePredicate;
import edu.cvtc.web.predicates.TitlePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * @author gcedarblade
 *
 */
public class MovieSearchImpl implements MovieSearch {

	private MovieDao movieDao = new MovieDaoImpl();
	
	@Override
	public List<Movie> retrieveMovies(String sortType) throws MovieSearchException {
		
		try {
			final List<Movie> movies = movieDao.retrieveMovie();
			
			if (null != sortType) {
				sortMovies(movies, sortType);
			}
			
			return movies;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("The list of movies could not be retrieved from the database.");
		}
		
	}
	
	private void sortMovies(final List<Movie> movies, final String sortType) {
		
		switch(sortType) {
			
			case SortBy.TITLE:
				Collections.sort(movies, new TitleComparator());
				break;
			case SortBy.LENGTH_IN_MINUTES:
				Collections.sort(movies, new LengthComparator());
				break;
			case SortBy.DIRECTOR:
				Collections.sort(movies, new DirectorComparator());
				break;
			default:
				break;
		
		}
	}

	@Override
	public List<Movie> findMoviesByTitle(String title) throws MovieSearchException {
		
		try {
			final List<Movie> movies = movieDao.retrieveMovie();
			return Lists.newArrayList(Collections2.filter(movies,  new TitlePredicate(title)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by title.");
		}
	}

	@Override
	public List<Movie> findMoviesByRunTime(Integer runTime) throws MovieSearchException {

		try {
			final List<Movie> movies = movieDao.retrieveMovie();
			return Lists.newArrayList(Collections2.filter(movies, new RunTimePredicate(runTime)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by run time.");
		}
	}

	@Override
	public List<Movie> findMoviesByDirector(String director) throws MovieSearchException {

		try {
			final List<Movie> movies = movieDao.retrieveMovie();
			return Lists.newArrayList(Collections2.filter(movies, new DirectorPredicate(director)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by director.");
		}
	}
	
	

}
