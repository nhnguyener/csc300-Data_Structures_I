package hw8;

import static org.junit.Assert.assertArrayEquals;

import java.util.NoSuchElementException;

/**
 * This is a skeleton file for your homework. Complete the functions below. You
 * may also edit the function "main" to test your code.
 * 
 * You should not use any loops or recursions.  Your code needs to run in
 * constant time.  It is OK if your testing code has loops (like in checkInvariants).
 *
 * You must not add fields or static variables. As always, you must not change
 * the declaration of any method nor the name of the class or of this file.
 */

public class Deque<T> {

	private Node<T> first;	// A reference to the first item in the Dequeue (or
							// null if empty)
	private Node<T> last;	// A reference to the last item in the Dequeue (or
							// null if empty)
	private int N; 			// The number of items currently in the Dequeue

	static class Node<T> {
		
		public T item;			// The data stored at this node.
		public Node<T> next;	// The node to the right (or null if there is no
								// node to the right)
		public Node<T> prev;	// The node to the lett (or null if there is no
								// node to the left)
	}

	/**
	 * Construct an empty <code>Deque</code>.
	 */
	public Deque() {
		// TODO
		N = 0;
		first = null;
		last = null;
	}

	/**
	 * Tests if the <code>Dequeue</code> is empty.
	 * 
	 * @return <code>true</code> if this <code>Deque</code> is empty and false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		// TODO
		// If you do not change any variables/nodes, there is no need to check invariants.
		return (N == 0);
	}

	/**
	 * Returns the number of items currenlty in this <code>Deque</code>.
	 * 
	 * @return the number of items currenlty in this <code>Deque</code>
	 */
	public int size() {
		// TODO
		// If you do not change any variables/nodes, there is no need to check invariants.
		return N;
	}

	/**
	 * Inserts an item into the front of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushFront(T item) {
		// TODO
		Node<T> newNode = new Node<T>();
		newNode.item = item;
		newNode.next = first;
		newNode.prev = null;
		if(first != null) {
			first.prev = newNode;
			if(N == 1) {
				last = first;
				last.next = null;
				first = newNode;
			} else if(N > 1) {
				first = newNode;
				Node<T> temp = first;
				while(temp.next != null) {
					temp = temp.next;
					last = temp;
				}
			}
			//first.prev = newNode;
			//first = newNode;
			
		} else {
			first = newNode;
			last = newNode;
			//first.next = last;
			//last.prev = first;
		}
		N++;
		assert checkInvariants();
	}

	/**
	 * Inserts an item into the back of this <code>Deque</code>.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void pushBack(T item) {
		// TODO
		N++;
		Node<T> newNode = new Node<T>();
		newNode.item = item;
		newNode.next = null;
		if(first == null) {
			newNode.prev = null;
			first = newNode;
			last = newNode;
			//first.next = last;
			return;
		}
		first.prev = null;
		last.next = newNode;
		newNode.prev = last;
		last = newNode;
		//checkInvariants();
	}

	/**
	 * Removes and returns the item at the front of this <code>Deque</code>.
	 * 
	 * @return the item at the front of this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popFront() {
		// TODO
		//System.out.println("New Pop Start: " + N);
		if(first == null) {
			throw new NoSuchElementException();
		}
		N--;
		//System.out.println("New Pop End: " + N);
		T result = first.item;
		Node<T> temp = first;
		if(first.next != null) {
			first.next.prev = null;
			first = first.next;
			//first.prev = null;
			while(temp.next != null) {
				temp = temp.next;
				last = temp;
			}
			temp.next = null;
		} else {
			first = null;
			last = null;
		}
		checkInvariants();
		return result;
	}

	/**
	 * Removes and returns the item at the back of this <code>Deque</code>.
	 * 
	 * @return the item at the back this <code>Deque</code>.
	 * @throws NoSuchElementException if this <code>Deque</code> is empty.
	 */
	public T popBack() {
		// TODO
		if(first == null) {
			throw new NoSuchElementException();
		}
		N--;
		T result = last.item;
		last.prev.next = null;
		Node<T> temp = last;
		last = last.prev;
		temp.prev = null;
		checkInvariants();
		return result;
	}
	
	public String toString() {
		String result = "";
		if(first != null) {
			while(first.next != null) {
				result += first.item.toString() + ", ";
				first = first.next;
			}
		}
		return result;
	}
	
	private boolean checkInvariants() {
		// When deque is empty, N==0 && first == null && last == null
		if (N == 0 || first == null || last == null) {
			assert N == 0;
			assert first == null;
			assert last == null;
			//System.out.println("empty good");
		}
		// If deque is not empty...
		else {
			// check that first.prev is null and last.next is null
			assert first.prev == null;
			//System.out.println("first prev null");
			assert last.next == null;
			//System.out.println("last next null");
			// traverse the deque counting the number of nodes
			// and making sure that the successor of each node
			// (except the last) points back to the node
			Node<T> current = first;
			int nodeCount = 1;
			while (current.next != null) {
				assert current.next.prev == current;
				//System.out.println("works" + current.item.toString());
				current = current.next;
				nodeCount++;
			}
			//System.out.println("node count " + nodeCount);
			//System.out.println("n count " + N);
			// check that last points to the last node we found
			assert current == last;
			//System.out.println("current is last");
			// check that N is the number of nodes
			assert N == nodeCount;
			//System.out.println("count right");
		}
		return true;
	}
}
