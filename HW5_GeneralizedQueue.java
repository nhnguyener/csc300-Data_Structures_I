package hw5;
import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
	int N;		// The number of items currently in the queue
	Item[] a;	// Contains the items in the queue in slots 0 through N-1
	
	/**
	 * Creates an empty queue.
	 */
	public GeneralizedQueue() {
		// TODO
		a = (Item[]) new Object[]{};
	}
	
	/**
	 * Checks if the queue is empty
	 * @return <code>true</code> if the queue is empty
	 * and <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		// TODO
		return N == 0;
	}
	
	/**
	 * Add an item to the back of the queue.
	 * @param x the item to be addded to the queue
	 */
	public void insert(Item x) {
		/*
		if(a != null) {
			if(N == a.length) {
				Item[] temp = (Item[]) new Object[2*a.length];
				for(int i = 0; i < N; i++) {
					temp[i] = a[i];
				}
				a = temp;
			}
			a[N++] = x;
			N++;
		}
		*/
		if (a.length == 0) {
			Item[] temp = (Item[]) new Object[1];
			a = temp;
			N++;
		}
		if (N == a.length) {
			Item[] tempB = (Item[]) new Object[2 * a.length];
			for(int i = 0; i < N; i++) {
				tempB[i] = a[i];
			}
			a = tempB;
		}
		a[N++] = x;
	}
	
	/**
	 * delete and return the kth least recently inserted item
	 * (the kth item "in line".)
	 * @param k indicates which position from the queue to be removed.
	 * The first item is in position 1.
	 * @return the kth oldest item in the queue
	 * @throws NoSuchElementException if there are fewer than k items in the queue.
	 */
	public Item delete(int k) throws NoSuchElementException {
		// TODO
		if (k > N - 1) {
			throw new NoSuchElementException("Out of bounds");
		}
		Item x = (Item) a[k];
		for(int i = k; i < N - 1; i++) {
			a[i] = a[i+1];
		}
		a[N - 1] = null;
		N--;
		if(N > 0 && N == a.length/4) {
			Item[] tempC = (Item[]) new Object[a.length/2];
			for(int i = 0; i < N; i++) {
				tempC[i] = a[i];
			}
			a = tempC;
		}
		return x;
	}
	
}
