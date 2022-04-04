/* 
    Time complexity: O(Q^2)
    Space complexity: O(Q)
    
    Where Q is the number of queries.
*/

import java.util.ArrayList;
public class HashSet {
	ArrayList<Integer> hashset = new ArrayList<>();

	// Adds the element in the ArrayList.
	void add(int key) {
		hashset.add(key);
	}

	// Searches the value in the hashtable.
	// If present, removes the element.
	int removeElement(int key) {
		boolean flag = false;
		for (int i = 0; i < hashset.size(); ++i) {
			if (hashset.get(i) == key) {
				hashset.remove(i);
				i--;
				flag = true;
			}
		}
		if (flag == true) {
			return key;
		} else {
			return -1;
		}
	}

	// Returns true if this set contains the specified element.
	boolean contains(int key) {
		for (int i = 0; i < hashset.size(); ++i) {
			if (hashset.get(i) == key) {
				return true;
			}
		}
		return false;
	}

}
