package hw2;

/**
 * 
 * A class that mimics how Java's String class behaves.
 *
 */
public class MyString {
	private char[] data;

	/**
	 * Construcs a <code>MyString</code> object to represent the text in
	 * <code>string</code>
	 * @param string the <code>String</code> we are representing.
	 */
	public MyString(String string) {
		data = new char[string.length() + 1];
		for(int i = 0; i <string.length(); i++) {
			data[i] = string.charAt(i);
		}
	}

	/**
	 * A lexicographical comparison of <code>this Mystring</code> to <code>other</code>.
	 * The comparison is case sensitive, meaning it might not return the correct answer
	 * if the text being compared isn't all the same case.
	 * 
	 * @param other the <code>MyString<code> to compare against.
	 * @return a negative number if <code>this</code> appears before <code>other</code>
	 * in the dictionary, a positive number if <code>this</code> appears after
	 * <code>other</code> in the dictonary, and 0 if <code>this</code> and <code>other</code>
	 * represent the same <code>String</code>
	 */
	public int compareTo(MyString other) {
		int i = 0;
		while (i < this.data.length) {
			if(this.data[i] != other.data[i]) {
		    	return this.data[i] - other.data[i];
			}
			i++;
		}
		return 0;
	}

	public char charAt(int i) {
		return data[i];
	}

	public int length() {
		int i = 0;
		while (data[i] != 0) {
			i++;
		}
		return i;
	}

	public int indexOf(char c) {
		for(int i = 0; i <= this.data.length -1; i++) {
			if(c == data[i]) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj == null) {
			return false;
		}
		if(!(obj instanceof MyString)) {
			return false;
		}
		MyString s = (MyString) obj;
		for(int i = 0; i < this.data.length; i++) {
			if(this.data[i] != s.data[i]) {
				return false;
			}
		}
		return true;
	}
}
