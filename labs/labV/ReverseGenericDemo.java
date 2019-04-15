package labs.labV;

public class ReverseGenericDemo {
	public static <T> void reverse(T[] data) {
		printArray(data);
		int low = 0, high = data.length - 1;
		while (low < high) { // swap data[low] and data[high]
			T temp = data[low];
			data[low++] = data[high]; // post-increment of low
			data[high--] = temp; // post-decrement of high
		}
		printArray(data);
	}
	
	private static <T> void printArray(T[] data) {
		System.out.print("[");
		for(int i = 0; i < data.length; i++) {
			if(data.length - 1 != i) {
				System.out.print(data[i] + ", ");
			}else {
				System.out.print(data[i] + "]\n");
			}
			
		}
	}
	
	public static void test() {
		Integer[] intsA = {2, 4, 6, 8, 10, 12, 14, 16};
		String[] stringA = {"are", "you", "as", "backwards", "as", "I", "am", "buddy"}; 
		reverse(intsA);
		reverse(stringA);		
	}
	
	public static void main(String[] args) {
		test();
		Song[] songs = new Song[5];
		songs[0] = new Song("Queen", "Hammer to Fall");
		songs[1] = new Song("Styx", "Castle Walls");
		songs[2] = new Song("Boston", "Rock and Roll Band");
		songs[3] = new Song("The Beatles", "Eleanor Rigby");
		songs[4] = new Song("Asia", "Heat of the Moment");
		reverse(songs);
	}
}
