 /*
    Time Complexity : O(1) for each operation
    Space Complexity : O(Q)

    Where 'Q' is the number of queries.
*/

import java.util.Stack;

public class MaxStack {
	// Initialize MaxStack.
	Stack<Integer> normalStack = new Stack<Integer>();
	Stack<Integer> maxStack = new Stack<Integer>();
	public MaxStack() {

	}

	public void specialPush(int value) {
		// Push the value in the normal stack.
		normalStack.push(value);
		// If the value is also the biggest value then push it into the max stack.
		if (maxStack.empty() == true || maxStack.peek() <= value) {
			maxStack.push(value);
		}

	}

	// Return the popped element.
	public int specialPop() {
		// Check whether stack is empty.
		if (normalStack.empty() == true) {
			return -1;
		}
		// If the top element in the normal stack is also the biggest element then pop that from max stack also.
        int normalTop =normalStack.peek();
        int maxTop =maxStack.peek();
		if (normalTop == maxTop) {
			maxStack.pop();
		}

		// Return the value at top of normal stack.
		int value = normalStack.peek();
		normalStack.pop();
		return value;
	}

	// Return value at the top of stack.
	public int specialTop() {
		// Check whether stack is empty.
		if (normalStack.empty() == true) {
			return -1;
		}

		// Return the top element of normal stack.
		return normalStack.peek();
	}

	// Return maximum value in stack.
	public int specialMax() {
		// Check whether stack is empty.
		if (normalStack.empty() == true) {
			return -1;
		}

		// Return the biggest element, that is the element at the top of max stack.
		return maxStack.peek();
	}

}
