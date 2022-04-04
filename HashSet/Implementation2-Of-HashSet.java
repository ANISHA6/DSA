/*
    Time complexity: O(1)
    Space complexity: O(ELEMENT)

    Where element is the largest value inserted in the HashSet.
*/

public class HashSet {
	boolean hash[];

	HashSet() {
		hash = new boolean[1000000];
	}

	// Adds the element by marking it true in the hash table.
	void add(int key) {
		hash[key] = true;
	}

	// Turns the removed element to false.
	int removeElement(int key) {
		if (hash[key] == true) {
			hash[key] = false;
			return key;
		} else {
			return -1;
		}
	}

	// Returns true if it contains the specified element.
	boolean contains(int key) {
		return hash[key] == true;
	}

}
