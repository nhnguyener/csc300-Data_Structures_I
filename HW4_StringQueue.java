package hw4;

import edu.princeton.cs.algs4.Stack;
// Stack API found at https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/Stack.html


public class StringQueue {
	//You may NOT add any more fields to this class.
	private Stack<String> stack1;
	private Stack<String> stack2;

	/**
	 * Initializes an empty queue.
	 */
	public StringQueue() {
		stack1 = new Stack<String>();
		stack2 = new Stack<String>();
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		if (stack1.isEmpty() == true && stack2.isEmpty() == true) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		return stack1.size() + stack2.size();
	}


	/**
	 * Adds the item to this queue.
	 *
	 * @param  item the item to add
	 */
	public void enqueue(String item) {
		stack1.push(item);
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 * FOR THIS ASSIGNMENT, YOU MAY ASSUME THAT DEQUEUE IS NEVER CALLED ON AN
	 * EMPTY QUEUE.
	 *
	 * @return the item on this queue that was least recently added
	 */
	public String dequeue() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
