/*
Approach 1
    Time complexity: O(Q^2)
    Space complexity: O(HASHTABLE_SIZE)
    
    Where ‘Q’ denotes the number of queries, ‘HASHTABLE_SIZE’ denotes the size of the hash table.
*/

import java.util.ArrayList;

public class HashSet {
	Object[] map;
	int factor;

	// Initialize your data structure here.
	public HashSet() {
		map = new Object[1000];//hash table
		factor = 1000;
	}

	public void add(int key) {
		int position = key % factor;
		if (map[position] == null) {
      //To avoid collision, we used ArrayList at each position of map
			map[position] = new ArrayList<Integer>(50);
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];//Taking the address of the arraylist
		if (!judge.contains(key)) {//contains() is a method in ArrayList to check wheather this element is present or not
			judge.add(key);//if not present, then only add
		}
	}

	public int removeElement(int key) {
		int position = key % factor;
		if (map[position] == null) {
			return -1;
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];
		Integer in = key;
		if (judge.remove(in)) {//remove() is a method in ArrayList to remove the element from ArrayList
			return key;
		} else {
			return -1;
		}
	}

	// Returns true if this set contains the specified element.
	public boolean contains(int key) {
		int position = key % factor;
		if (map[position] == null) {
			return false;
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];
		return judge.contains(key);
	}

}
