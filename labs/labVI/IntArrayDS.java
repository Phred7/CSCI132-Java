package labs.labVI;

public class IntArrayDS {

	private int capacity;
	private int[] elements;

	public IntArrayDS(int length) {
		this.capacity = length;
		this.elements = new int[this.capacity];
	}

	public IntArrayDS() {
		this(0);
	}

	public void clear() {
		this.capacity = 0;
		this.elements = new int[this.capacity];
	}

	public void addFront(int value) {
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

	public int getNth(int location) {
		if (location > this.capacity - 1) {
			throw new IndexOutOfBoundsException(
					"You scrub! That index is invalid! Try an int less than " + (this.capacity - 1));
		} else {
			return elements[location];
		}
	}

	public String toString() {
		String str = "[" + this.elements[0] + ",";
		for (int i = 1; i < this.capacity - 1; i++) {
			str = str + " " + Integer.toString(this.elements[i]) + ",";
		}
		str = str + " " + Integer.toString(this.elements[this.capacity - 1]) + "]";
		return str;
	}
}