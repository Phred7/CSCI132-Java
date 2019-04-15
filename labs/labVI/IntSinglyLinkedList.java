package labs.labVI;

public class IntSinglyLinkedList {
	private static class Node {

		// fields
		private int element; // reference to the element stored at this node
		private Node next; // reference to the subsequent node in the list

		// constructor
		public Node(int e, Node n) {
			this.element = e;
			this.next = n;
		}

		// methods
		public int getElement() {
			return this.element;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node n) {
			this.next = n;
		}

	} // ----------- end of nested Node class -----------

	// fields
	private Node head = null; // head node of the list (or null if empty)
	private Node tail = null; // last node of the list (or null if empty)
	private int size = 0; // number of nodes in the list

	// constructor
	public IntSinglyLinkedList() { }// constructs an initially empty list

	// methods
	public void clear() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public Integer first() { // returns (but does not remove) the first element
		if (this.isEmpty())
			return null;
		return this.head.getElement();
	}

	public Integer last() { // returns (but does not remove) the last element
		if (this.isEmpty())
			return null;
		return this.tail.getElement();
	}

	public void addFirst(Integer e) { // adds element e to the front of the list
		this.head = new Node(e, head); // create and link a new node
		if (this.size == 0)
			this.tail = this.head;
		this.size++;
	}

	public void addLast(Integer e) {
		Node newest = new Node(e, null);
		if (this.isEmpty())
			this.head = newest;
		else
			this.tail.setNext(newest);
		this.tail = newest;
		this.size++;
	}

	public Integer removeFirst() {
		if (this.isEmpty())
			return null;
		Integer answer = this.head.getElement();
		this.head = this.head.getNext();
		this.size--;
		if (this.size == 0)
			this.tail = null;
		return answer;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node walk = this.head;
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != this.tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

	public Integer getNth(int n) {
		Node node = this.head;
		for (int i = 0; i < n; i++) {
			node = node.getNext();
		}
		Integer nElement = node.getElement();
		return nElement;
	}

	public void addAfter(int n, int data) {
		this.size += 1;
		Node node = this.head;
		for (int i = 0; i < n; i++) {
			node = node.getNext();
		}
		Node dataNode = new Node(data, node.getNext());
		node.setNext(dataNode);
	}
}