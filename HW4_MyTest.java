package hw4;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class MyTest {
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);
	
	
	@Test
	public void toyTest() {
		/*
		 * This test
		 * 1. Instantiates a StringQueue
		 * 2. Verifies size and isEmpty
		 * 3. Inserts 2 items.
		 * 4. Verifies size and isEmpty
		 * 5. Removes 2 items verifying the items removed
		 * 6. Tests size and isEmpty
		 */
		StringQueue q = new StringQueue();
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
		q.enqueue("apple");
		q.enqueue("box");
		assertFalse(q.isEmpty());
		assertEquals(2, q.size());
		assertEquals("apple", q.dequeue());
		assertEquals("box", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
	}
	
	@Test
	public void testMixedSequence() {
		// Create your own test that tests a more complex sequence of enqueue and dequeue.
		// Make sure your test sequence inserts and removes items after fully emptying out
		// the queue as well as after partially emptying out the queue.
		StringQueue q = new StringQueue();
		assertTrue(q.isEmpty());
		//fully empty queue below
		q.enqueue("yi");
		q.enqueue("er");
		q.enqueue("san");
		assertEquals(3, q.size());
		assertEquals("yi", q.dequeue());
		assertEquals("er", q.dequeue());
		assertEquals("san", q.dequeue());
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
		//partially empty queue below
		q.enqueue("tres");
		q.enqueue("two");
		q.enqueue("uno");
		assertFalse(q.isEmpty());
		assertEquals(3, q.size());
		assertEquals("tres", q.dequeue());
		assertEquals("two", q.dequeue());
		q.enqueue("dos");
		q.enqueue("no");
		q.enqueue("tres");
		assertEquals(4, q.size());
	}
	
	@Test
	public void testMultipleQueues() {
		// Create a test that instantiates two queues and verifies they don't interfere with
		// each other.  Again, use a complex sequence of enqueue, dequeue, and size operations
		// on each of the two queues.
		StringQueue x = new StringQueue();
		StringQueue y = new StringQueue();
		assertTrue(x.isEmpty() && y.isEmpty());
		x.enqueue("q");
		x.enqueue("w");
		y.enqueue("z");
		x.enqueue("e");
		assertEquals(3, x.size());
		assertEquals(1, y.size());
		assertEquals("q", x.dequeue());
		assertEquals("z", y.dequeue());
		assertEquals(2, x.size());
		assertTrue(y.isEmpty());
		y.enqueue("done");
		assertEquals("done", y.dequeue());
		assertEquals(0, y.size());
	}

}
