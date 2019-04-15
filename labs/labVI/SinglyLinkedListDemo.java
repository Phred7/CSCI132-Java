package labs.labVI;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {
		SinglyLinkedList<String> airports = new SinglyLinkedList<>();
		airports.addFirst("BZN");
		airports.addFirst("BOS");
		airports.addFirst("SLC");
		airports.addFirst("LAX");
		airports.addFirst("SFO");
		airports.addFirst("JFK");
		airports.removeFirst();
		
		System.out.println(airports);
		
		SinglyLinkedList<Song> playlist = new SinglyLinkedList<>();
		playlist.addFirst(new Song("Aqualung", "Jethro Tull"));
		playlist.addLast(new Song("In The Air Tonight", "Phil Collins"));
		playlist.addLast(new Song("7 Years", "Lucas Graham"));
		playlist.addLast(new Song("Rock'n Me", "Steve Miller Band"));
		playlist.addLast(new Song("Night Moves", "Bob Seger"));
		playlist.addLast(new Song("Surface", "Aerochord"));
		playlist.addLast(new Song("Castle on the Hill", "Ed Sheeran"));
		playlist.addLast(new Song("Eastside", "Benny Blanco (with Halsey & Khalid)"));
		playlist.addLast(new Song("If You Want Love", "NF"));
		
		System.out.println(playlist);
		System.out.println(playlist.getNth(8));
		System.out.println(airports.getNth(2));
		//System.out.println(airports.last());
		airports.addAfter(2, "JFK");
		System.out.println(airports);
		
		SinglyLinkedList<String> quote = new SinglyLinkedList<>();
		quote.addFirst("a");
		quote.addLast("among");
		quote.addLast("But");
		quote.addAfter(1, "change.");
		quote.addLast("change.");
		quote.addAfter(3, "doesn't");
		quote.addAfter(0, "follow.");
		quote.addAfter(1, "goes");
		quote.addAfter(1, "It");
		quote.addAfter(6, "it");
		quote.addAfter(4, "that");
		quote.addAfter(0, "that");
		quote.addFirst("There's");
		quote.addAfter(1, "thread");
		quote.addAfter(7, "Things");
		quote.addAfter(3, "you");
		
		System.out.println(quote);
	}

}
