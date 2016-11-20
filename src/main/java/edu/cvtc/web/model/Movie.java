package edu.cvtc.web.model;

/**
 * @author gcedarblade
 *
 */
public class Movie {

	//Class variables
	private String title;
	private Integer lengthInMinutes;
	private String director;
	
	//Constructor
	public Movie(final String title, final int lengthInMinutes, final String director) {
		
		this.title = title;
		this.lengthInMinutes = lengthInMinutes;
		this.director = director;
		
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the lengthInMinutes
	 */
	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Movie: " + title + ", Length: " + lengthInMinutes + ", Directed by: " + director + ".";
	}
	
	
}
