package labs.labV;

public class Song {

	/*private static String[] Artist = {"Queen", "Styx", "Boston", "The Beatles", "Asia"};
	private static String[] Title = {"Hammer to Fall", "Castle Walls", "Rock and Roll Band", "Eleanor Rigby", "Heat of the Moment"};
	public static String[] Songs = new String[5];
	*/
	
	public String Artist;
	public String Title;
	
	public Song(String artist, String title) {
		this.Artist = artist;
		this.Title = title;
	}
	
	@Override
	public String toString() {
		return "[" + this.Title + " (" + this.Artist + ")]"; 
	}
	
	/*public static void main(String[] args) {
		Songs = generatePlaylist(Artist, Title, Songs);
		ReverseGenericDemo.test();
		ReverseGenericDemo.reverse(Songs);
	}
	
	private static String[] generatePlaylist(String[] artist, String[] title, String[] list) {
		for(int i = 0; i < list.length; i++) {
		list[i] = title[i].toString() + " (" + artist[i].toString() + ")";
		}
		return list;
	}*/

}
