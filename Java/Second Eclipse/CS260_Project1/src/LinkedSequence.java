
public class LinkedSequence<E> implements Cloneable {

	
	private Node<E> head, tail, cursor, precursor;
	private Node<E>dummy = new Node<E>(null,null);
	private int manyItems = 0;




	/**Class Constructor
	 * @param newHead
	 */
	public LinkedSequence(Node<E> head) {

		this.head = head;
		tail = Node.getTail(head);
		dummy.setLink(head);
	}

	/**
	 * adds a new node after cursor
	 * 
	 * @param new Data
	 * @return - added node
	 */

	public Node<E> addAfter(E element) {

		Node<E> temp;

		if (head == null) {

			cursor = dummy.addNodeAfter(element);

			dummy.link = cursor;

			head = cursor;

			return cursor;

		} else if (cursor == null) {

			temp = tail.addNodeAfter(element);

			tail.link = temp;

			tail = temp;

			return temp;

		} else {

			precursor = cursor;

			return precursor.link = cursor.addNodeAfter(element);

		}

	}

	public int getItems()
	{
		return manyItems;
	}


	/**
	 * adds a node before cursor
	 * 
	 * @param newData
	 * @return added node
	 */
	public Node<E> addBefore(E newData) {

		Node<E> temp;

		if (precursor == null) {

			head = dummy.addNodeAfter(newData);

			head.link = cursor;

			cursor = head;

			tail = cursor.link;

			precursor = dummy;

			return head;

		} else {

			temp = cursor;

			cursor = precursor.addNodeAfter(newData);

			precursor.link = cursor;

			return cursor;

		}

	}

	/**
	 * Adds a LinkedSeq. to the LinkedSeq.
	 * @param other LinkedSeq.
	 */
	public void addAll(LinkedSequence<E> other) {

		if (other == null) {

			return;

		} else if (head == null && other != null) {

			this.head = other.head;

			this.tail = other.tail;

		} else {

			Node<E> copy = Node.listCopy(other.head);

			tail.setLink(copy);

			tail = Node.getTail(head);

		}

	}
	/**
	 * moves nodes forward in the sequence
	 */
	public void advance() {

		if (!isCurrent()) {

			System.err.println("Error!");

		}
		if (cursor == null) {

			cursor = head;

		} else if (!cursor.equals(tail)) {

			precursor = cursor;

			cursor = null;

		} else {

			precursor = cursor;

		}

	}

	/**
	 * makes a copy of the sequence
	 */

	public LinkedSequence<E> clone() {

		LinkedSequence<E> clone;

		try {

			clone = (LinkedSequence<E>) super.clone();

		} catch (CloneNotSupportedException e) {

			throw new RuntimeException(

					"This class does not implement Cloneable");

		}

		return clone;

	}

	/**
	 * links two sequences together
	 * 
	 * @param links1
	 * @param links2
	 * @return concatenated LinkedSequence, newLinks
	 */

	public static LinkedSequence<Object> concatenate(LinkedSequence<Object> links1, LinkedSequence<Object> links2)
	{

		if (links1 == null || links2 == null) {
			System.err.println("ERROR! link is null.");
		}
		LinkedSequence<Object> newLinks = new LinkedSequence<Object>(null);
		newLinks.addAll(links1);
		newLinks.addAll(links2);
		return newLinks;

	}




	/**
	 * Starts linked sequence
	 */

	public void start() {

		cursor = head;

	}

	/**
	 * Checks if cursor is not empty
	 * @return boolean refering to the current node being manipulated is empty or not
	 */

	public boolean isCurrent() {

		if (cursor != null) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * gets the current link data
	 * 
	 * @return
	 */

	public E getCurrent() {

		if (!isCurrent()) {

			System.err.println("Error: current has no element");

		}
		return cursor.data;

	}

	/**
	 * 
	 * @return displays the toString from the Node class
	 */

	public String displayList() {

		return head.toString();

	}




	/**
	 * removes the current node
	 */

	public void removeCurrent() {

		if (!isCurrent()) {
			System.err.println("Error: current has no element");
		}
		manyItems--;

		if (manyItems == 0) {
			tail = null;
		}
		if (cursor == head) {
			head = cursor;
			cursor = head.link;
		} else {
			Node<E> previous = head;
			while (previous.link != cursor) {
				previous = previous.link;
			}
			if (cursor == tail) {
				tail = previous;
			}
			previous.setLink(cursor.link);
			cursor = cursor.link;
		}

	}

	/**
	 * Mutators and Accessor methods for the class instance fields are all provided below
	 * Excludes dummy field
	 */

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}
	
	public Node<E> getCursor() {
		return cursor;
	}
	
	public void setCursor(Node<E> cursor) {
		this.cursor = cursor;
	}

	public Node<E> getPrecursor() {
		return precursor;
	}

	public void setPrecursor(Node<E> precursor) {
		this.precursor = precursor;
	}

}


