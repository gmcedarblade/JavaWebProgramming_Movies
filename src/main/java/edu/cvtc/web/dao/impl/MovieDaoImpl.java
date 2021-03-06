package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author gcedarblade
 *
 */
public class MovieDaoImpl implements MovieDao{

	private static final String DROP_TABLE_MOVIE = "drop table if exists movie;";
	private static final String CREATE_TABLE_MOVIE = "create table movie (id integer primary key autoincrement,"
			+ "title text, runTime integer, director text);";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie;";
	
	@Override
	public void populateMovieTable(final String filePath) throws Exception {
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMovieFromWorkbook(inputFile);
			
			for (final Movie movie : movies) {
				
				String insertValues = "insert into movie (title, runTime, director) values ("
						+ "'" + movie.getTitle() + "', " + movie.getLengthInMinutes() + ", '" + movie.getDirector() + "');";
				
				System.out.println(insertValues);
				
				statement.executeUpdate(insertValues);
				
			}
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
	}

	@Override
	public List<Movie> retrieveMovie() throws MovieDatabaseException {
		
		final List<Movie> movies = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (results.next()) {
				
				final String title = results.getString("title");
				final int runTime = results.getInt("runTime");
				final String director = results.getString("director");
				
				final Movie movie = new Movie(title, runTime, director);
				movies.add(movie);
				
			}
			
			results.close();
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieDatabaseException("Error retrieving movies from the database.");
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movies;
	}

	@Override
	public Integer insertMovie(final Movie movie) throws MovieDatabaseException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String insertSQL = "insert into movie (title, runTime, director) "
					+ "values (?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setInt(2, movie.getLengthInMinutes());
			preparedStatement.setString(3, movie.getDirector());
			
			preparedStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			return preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieDatabaseException("Error adding this movie to the database.");
		} finally {
			DBUtility.closeConnections(connection, preparedStatement);
		}
		
	}
}
