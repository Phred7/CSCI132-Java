package week0;

public class Counter {
	
	private int count; //Fields (instance variables)
	
	
	public Counter() { //Constructor
		count = 0;
	}
	
	public Counter(int startingValue) { //Constructor with one param
		count = startingValue;
	}
	
	//Methods (below)
	public void reset() {
		count = 0;
	}
	
	public int getCount() {
		return count;
	}
	
	public void increment() { // no params
		count++;
	}
	
	public void increment(int delta) { //one param
		count += delta;
	}

}
