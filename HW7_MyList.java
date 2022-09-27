package hw7;

import java.util.NoSuchElementException;

import hw6.MyList;
import hw6.MyList.MyListNode;

public class MyList<Item> {
	
	private class MyListNode {
		public Item item;
		public MyListNode next;
		
		public MyListNode(Item i, MyListNode n) {
			item = i;
			next = n;
		}
	}
	
	private MyListNode first;
		
	/**
	 * Creates an empty list.
	 */
	public MyList() {
		first = null;
	}
	
	/**
	 * Inserts an item at the front of the list
	 * 
	 * @param item the item to be inserted
	 */
	public void insertAtFront(Item item) {
		MyListNode node = new MyListNode(item, first);
		first = node;
	}
	
	/**
	 * Returns the number of items equal to {@code target} in the list
	 * 
	 * @param target the data item to count
	 * @return the number of times {@code target} appears in the list
	 */
	public int count(Item target) {
		return countH(first, target);
	}
	
	private int countH(MyListNode first, Item target) {
		// TODO
		if(first == null) {
			return 0;
		}
		if(first.item == target) {
			return 1 + countH(first.next, target);
		}
		return countH(first.next, target);
	}
	


	/**
	 * Returns the data in position {@code index} in the list.
	 * Note that like arrays the first data item is in position 0.
	 * @param index the index of the item to get from the list
	 * @throws NoSuchElementException if the list doesn't have a 
	 * position {@code index}
	 * @return the data in position {@code index} in the list.
	 */
	public Item get(int index) {
		if (index < 0)
			throw new NoSuchElementException();
		return getH(first, index);
	}

	
	/* Assumes index is not negative */
	private Item getH(MyListNode first, int index) {
		// TODO
		/*
		int c = 1;
		if(first == null) {
			throw new NoSuchElementException();
		} 
		if(c == index) {
			return first.item;
		}
		return getH(first.next, index - 1);
		*/
		
		if(first == null) {
			throw new NoSuchElementException();
		}
		int n = 0;
		MyListNode test = first;
		while(test.next != null) {
			n++;
			test = test.next;
		}
		if(index > n || index < 0) {
			throw new NoSuchElementException();
		}
		MyListNode temp = first;
		for(int i = 0; i < index; i++) {
			if(temp == null) {
				throw new NoSuchElementException();
			}
			temp = temp.next;
		}
		return temp.item;
		
	}

	
	/**
	 * Constructs a separate copy of a list.  Changes to the copy do not affect the original.
	 * @return the first node of the copy
	 */
	public MyList<Item> copy() {
		MyList<Item> answer = new MyList<Item>();
		answer.first = copyH(first);
		return answer;
	}
	
	/* returns the first node of a copy of the list whose first node is the argument first */
	private MyListNode copyH(MyListNode first) {
		// TODO
		if(first == null) {
			return null;
		}
		MyListNode newNode = new MyListNode(first.item, first);
		newNode.next = copyH(first.next);
		return newNode;
		/*
		MyList<Item> listCopy = new MyList<Item>();
		MyListNode temp = first;
		while(temp != null) {
			listCopy.insertAtFront(temp.item);
			temp = temp.next;
		}
		MyList<Item> tList = new MyList<Item>();
		MyListNode temp2 = listCopy.first;
		while(temp2 != null) {
			tList.insertAtFront(temp2.item);
			temp2 = temp2.next;
		}
		listCopy = tList;
		return listCopy.first;
		*/
	}

	/**
	 * Constructs a {@code String} representation of the list.  The {@code String}
	 * is a comma separated listing of the {@code String} representations of the items
	 * in the same order they appear in the list.  There are no spaces between items.
	 * @return a {@code String} representation of the list.
	 */
	public String convertToString() {
		if (first == null)
			return "";
		return convertToStringH(first);
	}
	
	
	/* Assumes first is not null */
	public String convertToStringH(MyListNode first) {
		// Hint: for this function, make the base case a list of size 1
		//       instead of using the empty list as the base case.
		// TODO
		if(first.next != null) {
			return first.item.toString() + "," + convertToStringH(first.next);
		} else {
			return first.item.toString();
		}
	}
	
	/**
	 * Deletes the first occurrence of {@code target} from the list if it is present.
	 * Does nothing if {@code target} is not present.
	 * 
	 * @param target the item to be deleted
	 */
	public void delete(Item target) {
		first = deleteH(first, target);
	}
	
	/* returns the first node of the modified list */
	public MyListNode deleteH(MyListNode first, Item target) {
		// TODO
		if(first == null) {
			return null;
		}
		if(first.item == target) {
			return first.next;
		}
		return new MyListNode(first.item, deleteH(first.next, target));
		
		/*
		if(first.item.equals(target)) {
			first = first.next;
			return first;
		}
		MyListNode t1 = first;
		MyListNode t2 = null;
		MyListNode check = first;
		boolean tpres = false;
		while(check != null) {
			if(check.item == target) {
				tpres = true;
			}
			check = check.next;
		}
		if(!tpres) {
			return first;
		}
		while(t1 != null && !t1.item.equals(target)) {
			t2 = t1;
			t1 = t1.next;
		}
		t2.next = t1.next;
		return first;
		*/
	}
}
