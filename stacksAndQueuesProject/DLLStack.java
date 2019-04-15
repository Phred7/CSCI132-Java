package stacksAndQueuesProject;

public class DLLStack<E> implements Stack<E> {
	private DoublyLinkedList<E> dll = new DoublyLinkedList<>(); //DLL used as this Stack

	/**
	 * Constructor
	 * Preforms no operations
	 */
	public DLLStack() {

	}

	@Override
	/**
	 * Gets the size/length/number of elements on this Stack
	 * @return the size/length/number of elements on this Stack
	 */
	public int size() {
		return dll.size();
	}

	@Override
	/**
	 * Checks to see if this Stack contains any elements
	 * @return true if there are no elements and false if there this Stack contains elements
	 */
	public boolean isEmpty() {
		return dll.isEmpty();
	}

	@Override
	/**
	 * Adds an element to this Stack (to the top)
	 */
	public void push(E e) {
		dll.addFirst(e);
	}

	@Override
	/**
	 * Gets the next (top) element in this Stack
	 * @return next (top) element in this Stack
	 */
	public E top() {
		return dll.first();
	}

	@Override
	/**
	 * Removes the next (top) element from this Stack
	 * @return the element removed from this Stack
	 */
	public E pop() {
		E removed = dll.removeFirst();
		return removed;
	}

	@Override
	/**
	 * Converts this Stack to a String
	 * @returns this Stack as a String
	 */
	public String toString() {
		return dll.toString();
	}
	
	/**
	 * Empties the DLL, essentially clears this Stack so the same Stack Object can be reused without overlap
	 */
	public void clear() {
		dll = new DoublyLinkedList<>();
	}
}
