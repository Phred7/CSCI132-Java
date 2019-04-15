package stacksAndQueuesProject;

public class DLLQueue<E> implements Queue<E> {

	private DoublyLinkedList<E> dll = new DoublyLinkedList<>();
	
	/**
	 * Constructor
	 * Performs no operations
	 */
	public DLLQueue() {
	}

	@Override
	/**
	 * Gets the size/length/number of elements in this Queue
	 * @return the size/length/number of elements in this Queue
	 */
	public int size() {
		return dll.size;
	}

	@Override
	/**
	 * Checks to see if this Queue contains any elements
	 * @return true if there are no elements and false if there this Queue contains elements
	 */
	public boolean isEmpty() {
		return dll.isEmpty();
	}

	@Override
	/**
	 * Adds element e to the end of this Queue
	 */
	public void enqueue(E e) {
		dll.addLast(e);
	}

	@Override
	/**
	 * Gets the first element in this Queue
	 * @return the first element in this Queue
	 */
	public E first() {
		return dll.first();
	}

	@Override
	/**
	 * Removes the first element in this Queue
	 * @return the first element in this Queue
	 */
	public E dequeue() {
		return dll.removeFirst();
	}

	@Override
	/**
	 * Converts this Queue to a String for easy printing
	 * @return String version of this Queue
	 */
	public String toString() {
		return dll.toString();
	}
}
