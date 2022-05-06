/*
   Time Complexity  : O(N)
   Space Complexity : O(N)

   Where N is the total number of nodes in the binary tree.

*/

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {

		// Declare an empty array answer to store zigzag traversal
		List<Integer> answer = new ArrayList<>();

		// Base case
		if (root == null) {
			return answer;
		}

		// Declare two empty stacks for odd level and even level
		Stack<BinaryTreeNode<Integer>> oddLevel = new Stack<>();
		Stack<BinaryTreeNode<Integer>> evenLevel = new Stack<>();

		// Push root to odd level
		oddLevel.push(root);

		// Run a loop until both stacks are not empty
		while (evenLevel.isEmpty() == false || oddLevel.isEmpty() == false) {

			// Pop nodes from odd level and push it into even level
			while (oddLevel.isEmpty() == false) {

				// Pop the top node odd level
				BinaryTreeNode<Integer> topNode = oddLevel.pop();

				// Add data of popped node to the answer
				answer.add(topNode.data);

				// Push left and right child of popped node to
				// Even level stack
				if (topNode.left != null) {
					evenLevel.push(topNode.left);
				}
				if (topNode.right != null) {

					evenLevel.push(topNode.right);
				}
			}

			// Pop nodes from even level and push it into odd level
			while (evenLevel.isEmpty() == false) {

				// Pop the top node even level
				BinaryTreeNode<Integer> topNode = evenLevel.pop();

				// Add data of popped node to the answer
				answer.add(topNode.data);

				// Push right and left child of popped node to
				// odd level stack
				if (topNode.right != null) {
					oddLevel.push(topNode.right);
				}
				if (topNode.left != null) {
					oddLevel.push(topNode.left);
				}
			}
		}

		// Return the answer
		return answer;
	}
}
