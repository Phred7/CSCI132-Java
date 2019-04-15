package arrayVSLinked;

public class ArrayDS {

	private int capacity; // length of the array
	private int[] elements; // int array of the elements of the array

	/**
	 * Constructor: creates this array of some length
	 * 
	 * @param length
	 */
	public ArrayDS(int length) {
		this.capacity = length;
		this.elements = new int[this.capacity];
	}

	/**
	 * Constructor: creates this array of length 0. No elements or indexes just a
	 * location in mem.
	 */
	public ArrayDS() {
		this(0);
	}

	/**
	 * empties this array and sets the capacity to 0
	 */
	public void clear() {
		this.capacity = 0;
		this.elements = new int[this.capacity];
	}

	/**
	 * adds an element to the front of this array Creates a temp array with all the
	 * elements and re-constructing this array then setting each temp element equal
	 * to its respective element in this array
	 * 
	 * @param value the element to be added to this array
	 */
	public void addFirst(int value) {
		this.capacity++;
		if (this.capacity == 1) {
			this.elements = new int[1];
			this.elements[0] = value;
		} else {
			int[] temp = this.elements.clone();
			this.elements = new int[this.capacity];
			for (int i = (this.capacity - 1); i > 0; i--) {
				this.elements[i] = temp[i - 1];
			}
			this.elements[0] = value;
		}
	}

	/**
	 * adds an element to the end of this array Creates a temp array with all the
	 * elements and re-constructing this array Then setting each temp element equal
	 * to its respective element in this array
	 * 
	 * @param value the element to be added to this array
	 */
	public void addLast(int value) {
		this.capacity++;
		if (this.capacity == 1) {
			this.elements = new int[1];
			this.elements[0] = value;
		} else {
			int[] temp = this.elements.clone();
			this.elements = new int[this.capacity];
			for (int i = 0; i < (this.capacity - 1); i++) {
				this.elements[i] = temp[i];
			}
			this.elements[this.capacity - 1] = value;
		}
	}

	/**
	 * Gets to element at a given index for this array
	 * 
	 * @param location the index of the desires element
	 * @return the element as an int
	 */
	public int getNth(int location) {
		if (location > this.capacity - 1) {
			throw new IndexOutOfBoundsException(
					"You scrub! That index is invalid! Try an int less than " + (this.capacity - 1));
		} else {
			return elements[location];
		}
	}

	/**
	 * Converts this array to a useful string Generally used for print statements
	 * 
	 * @return the String version of this array
	 */
	public String toString() {
		String str = "[" + this.elements[0] + ",";
		for (int i = 1; i < this.capacity - 1; i++) {
			str = str + " " + Integer.toString(this.elements[i]) + ",";
		}
		str = str + " " + Integer.toString(this.elements[this.capacity - 1]) + "]";
		return str;
	}
}