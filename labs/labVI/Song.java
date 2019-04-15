package labs.labVI;

/**
 * A class to model a song by title and artist
 * 
 * @author danieldefrance
 */

public class Song {
	
	// Fields
	private String title;
	private String artist;
	
	// Constructor
	/**
	 * Constructs a new Song instance.
	 * 
	 * @param t		the title of the song (e.g., "I Should Live in Salt")
	 * @param a		the artist (e.g., "The National")
	 */
	public Song (String t, String a) {
		this.title = t;
		this.artist = a;
	}
	
	// Methods
	/** @return		title of song */
	public String getTitle() {
		return this.title;
	}
	
	/** @return		artist of song */
	public String getArtist() {
		return this.title;
	}
	
	/** @return		title and artist of the song: title, (artist) */
	public String toString() {			// override toString method
		return(title + " (" + artist + ")");
	}
}
