//Method 1, Using recursion

/*  

    Time Complexity : O(L)
    Space Complexity : O(L / K)

    Where L is the number of nodes in the Linked-List.
    Where K is the minimum block size from the array B.

 */

public class Solution {
	public static Node reverseKElements(Node head, int n, int b[], int idx) {

		// Base case: List is empty or entire block array have been considered.
		if (head == null || idx >= n) {
			return head;
		}

		// K is the size of the current block.
		int K = b[idx];

		// Just move to the next block if size of the current block is zero.
		if (K == 0) {
			return reverseKElements(head, n, b, idx + 1);
		}

		Node cur = head, prev = null, ahead = null;

		// Variable to keep track of the number of nodes reversed in the current block.
		int cnt = 0;

		// Reverse nodes until end of list is reached or current block has been reversed.
		while (cur != null && cnt < K) {
			ahead = cur.next;
			cnt++;
			cur.next = prev;
			prev = cur;
			cur = ahead;
		}

		// Reverse the next block.
		head.next = reverseKElements(ahead, n, b, idx + 1);
		return prev;
	}

	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {

		// If linked list is empty, return head of the linked list.
		if (head == null) {
			return null;
		}

		// Calling reverseKElements function to modify the given linked list.
		head = reverseKElements(head, n, b, 0);

		// Return the head of the linked list.
		return head;
	}
}

//Method 2, Iterative approach
/*  

    Time Complexity : O(L)
    Space Complexity : O(1)

    Where L is the number of nodes in the Linked-List.

 */

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// If linked list is empty, return head of the linked list.
		if (head == null) {
			return null;
		}

		// Variable to keep track of the current index in the block array.
		int idx = 0;

		Node prev = null, cur = head, temp = null;
		Node tail = null, join = null;
		boolean isHeadUpdated = false;

		// Reverse nodes until the list is empty or entire block array has been considered.
		while (cur != null && idx < n) {

			// K represents the size of the current block.
			int K = b[idx];

			// Just move to the next block if size of the current block is zero.
			if (K == 0) {
				idx++;
				continue;
			}

			join = cur;
			prev = null;

			// Reverse nodes until end of list is reached or current block has been reversed.
			while (cur != null && K-- > 0) {
				temp = cur.next;
				cur.next = prev;
				prev = cur;
				cur = temp;
			}

			// Update the head pointer when reversing the first block.
			if (isHeadUpdated == false) {
				head = prev;
				isHeadUpdated = true;
			}

			// Tail pointer keeps track of the last node before the current K-reversed linked list. 
        	// We join the tail pointer with the current K-reversed linked list's head. 
			if (tail != null) {
				tail.next = prev;
			}

			// The tail is then updated to the last node of the current K-reversed linked list.
			tail = join;
			idx++;
		}

		// If entire block is iterated and reached at end, then we append the remaining nodes to the tail of the partial modified linked list.
		if (tail != null) {
			tail.next = cur;
		}

		// Return the head of the linked list.
		return head;
	}
}
