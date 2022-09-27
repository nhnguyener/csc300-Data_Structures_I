package hw1;

public class HW1 {
	/**
	 * Returns the number of <code>String</code>s from <code>array</code> that begin
	 * with the character <code>c</code>.
	 * @param array the array of <code>String</code>s
	 * @param c the beginning character to look for
	 * @return the number of <code>String</code>s from <code>array</code> that begin
	 * with the character <code>c</code>
	 */
	public static int countBeginsWith(String[] array, char c) {
		int arrayCount = 0;
		int wordCount = 0;
		while (arrayCount < array.length) {
			if(array[arrayCount].charAt(0) == c) {
				wordCount++;
			}
			arrayCount++;
		}
		return wordCount;
	}
	
	/**
	 * Returns the first maximal length <code>String</code> in <code>array</code>.  (In other words,
	 * if more than one <code>String</code> tie for longest, the one appearing first in the array is
	 * returned.
	 * @param array an array of <code>String</code>s
	 * @return the first maximal length <code>String</code> in <code>array</code>.
	 */
	public static String longest(String[] array) {
		int arrayCount = 1;
		String longWord = array[0];
		while (arrayCount < array.length) {
			if (array[arrayCount].length() > array[arrayCount - 1].length()) {
				if (array[arrayCount].length() > longWord.length()) {
					longWord = array[arrayCount];
				}
			} else if (array[arrayCount].length() == array[arrayCount - 1].length()) {
				if (array[arrayCount-1].length() > longWord.length()) {
					longWord = array[arrayCount - 1];
				}
			}
			arrayCount++;
		}
		return longWord;
	}
	
	/**
	 * Returns the smallest String using lexicographical order.  It is case sensitive so for example, "Zoo" < "apple"
	 * @param array an array of <code>String</code>s
	 * @return the minimum <code>String</code> in lexicographical order.
	 */
	public static String min(String[] array) {
		int arrayCount = 1;
		String smallString = array[0];
		while (arrayCount < array.length) {
			if (array[arrayCount].charAt(0) < smallString.charAt(0)) {
				smallString = array[arrayCount];
			} else if (array[arrayCount].charAt(0) == smallString.charAt(0)) {
				int cCount = 1;
				String smallerWord = "";
				if(array[arrayCount].length() < smallString.length()) {
					smallerWord = array[arrayCount];
				} else {
					smallerWord = smallString;
				}
				while (cCount < smallerWord.length() - 1) {
					if(array[arrayCount].charAt(cCount) < smallString.charAt(cCount)) {
						smallString = array[arrayCount];
					}
					cCount++;
				}
			}
			arrayCount++;
		}
		return smallString;
	}	
	
	/**
	 * Returns <code>true</code> if the array contains any duplicate <code>String</code>s and false otherwise.
	 * @param array an array of <code>String</code>s
	 * @return <code>true</code> if the array contains any duplicate <code>String</code>s and false otherwise.
	 */
	public static boolean containsDuplicate(String[] array) {
		int aCount = 0;
		while(aCount < (array.length - 1)) {
			String baseWord = array[aCount];
			int bCount = aCount+1;
			while(bCount < (array.length)) {
				if(array[bCount].equals(baseWord)) {
					return true;
				}
				bCount++;
			}
			aCount++;
		}
		return false;
	}
	
	/**
	 * Returns the <code>String</code> with the leftmost occurence of the character <code>c</code>.  If more than one
	 * <code>String</code> qualifies, then the first such <code>String</code> is returned.  If there is no
	 * <code>String</code> that contains <code>c</code>, then the empty <code>String</code> is returned.
	 * @param array an array of <code>String</code>s.
	 * @param c the character to look for
	 * @return the <code>String</code> with the leftmost occurence of the character <code>c</code>.  If more than one
	 * <code>String<code> qualifies, then the first such <code>String</code> is returned.  If there is no
	 * <code>String</code> that contains <code>c</code>, then the empty <code>String</code> is returned.
	 */
	public static String leftmostOccurrence(String[] array, char c) {
		int aCount = 0;
		String lMost = "";
		int pos = 9999;
		while(aCount < array.length) {
			if(array[aCount].indexOf(c) > -1) {
				if(array[aCount].indexOf(c) < pos) {
					pos = array[aCount].indexOf(c);
					lMost = array[aCount];
				}
			}
			aCount++;
		}
		return lMost;
	}
}
