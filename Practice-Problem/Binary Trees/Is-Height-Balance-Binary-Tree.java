//Using recursion
/*
    Time complexity: O(N^2)
    Space complexity: O(N)

    Where 'N' is number of nodes in binary tree.
*/

public class Solution {

	private static int height(BinaryTreeNode<Integer> root) {

		// Base condition.
		if (root == null) {
			return 0;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		
        // Base condition.
		if (root == null) {
			return true;
		}

		// Height of left and right child subtree.
		int heightLeft = height(root.left);
		int heightRight = height(root.right);

		// Allowed only height difference '0, 1, -1' and both subtrees balanced.
		if (isBalancedBT(root.left) == true && isBalancedBT(root.right) == true
				&& Math.abs(heightLeft - heightRight) <= 1) {
			return true;
		}

		// If current subtree is not balanced.
		return false;
	}

}

//Method 2, optimal approach
/*
    Time complexity: O(N)
    Space complexity: O(N)

    Where 'N' is number of nodes in binary tree.
*/

public class Solution {

	private static int helperMethod(BinaryTreeNode<Integer> root) {

		// Base case.
		if (root == null) {
			return 0;
		}

		int leftValue = helperMethod(root.left);
		int rightValue = helperMethod(root.right);

		// If one of them is '-1' then child subtree are not balanced.
		if (leftValue == -1 || rightValue == -1) {
			return -1;
		}

		// Allow only '0, -1, 1' height differencein 'left' child subtree height and
		// 'right' subtree height.
		if (Math.abs(leftValue - rightValue) <= 1) {
			return Math.max(leftValue, rightValue) + 1;
		}

		// If left and right child subtree height more than '2'.
		return -1;
	}

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {

		// Base condition.
		if (root == null) {
			return true;
		}

		// If root tree is balanced.
		if (helperMethod(root) != -1) {
			return true;
		} else {
			return false;
		}
	}

}
