//Method 1

/*  
    Time Complexity : O(N^2)
    Space Complexity : O(N)

    where 'N' is the number of nodes in the Binary Tree.
*/

public class Solution {
	// Function to calculate the maximum sum from node to leaf.
	public static long findMaxSumNodeToLeaf(TreeNode root) {
		if (root == null) {
			return 0;
		}

		long maxSumLeftPath = findMaxSumNodeToLeaf(root.left);
		long maxSumRightPath = findMaxSumNodeToLeaf(root.right);

		long maxSumFromNodeToLeaf = root.data + Math.max(maxSumLeftPath, maxSumRightPath);

		return maxSumFromNodeToLeaf;
	}

	// Function to calculate the maximum sum of path between two leaves that passes through a node.
	public static long findMaxSumPathViaNode(TreeNode root)
	{
		if (root == null)
		{
			return -1;
		}

		// Variable to store the maximum sum of path between two leaves for the given tree.
		long maxPathSum = -1;

		// Variable to store the max length of path from left child to leaf.
		long maxSumPathFromLeft = findMaxSumNodeToLeaf(root.left);
		// Variable to store the max length of path from right child to leaf.
		long maxSumPathFromRight = findMaxSumNodeToLeaf(root.right);

		if (root.left != null && root.right != null)
		{
			long maxSumPathViaNode = maxSumPathFromLeft + maxSumPathFromRight + root.data;
			maxPathSum = Math.max(maxPathSum, maxSumPathViaNode);
		}

		maxPathSum = Math.max(maxPathSum, Math.max(findMaxSumPathViaNode(root.left), findMaxSumPathViaNode(root.right)));

		return maxPathSum;
	}

	public static long findMaxSumPath(TreeNode root) {
		return findMaxSumPathViaNode(root);
	}
}

//Method 2
/*  
    Time Complexity : O(N)
    Space Complexity : O(N)

    where 'N' is the number of nodes in the Binary Tree.
*/

class Number{
    long num;
    Number(long num)
    {
        this.num = num;
    }
}

public class Solution {
	public static long findMaxSumPathHelper(TreeNode root, Number maxPathSum) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		/* 
			Variable to store the maximum sum of the path from the current node to leaf
		 	in the left subtree.
		*/
		long maxSumLeftPath = findMaxSumPathHelper(root.left, maxPathSum);

		/*
			Variable to store the maximum sum of the path from the current node to leaf
		 	in the right subtree.
		*/
		long maxSumRightPath = findMaxSumPathHelper(root.right, maxPathSum);

		// If the current node has both children, update the value of maxPathSum.
		if (root.left != null && root.right != null) {

			maxPathSum.num = Math.max(maxPathSum.num, maxSumLeftPath + maxSumRightPath + root.data);
			return Math.max(maxSumLeftPath, maxSumRightPath) + root.data;

		} else if (root.left == null) {

			return maxSumRightPath + root.data;

		} else {

			return maxSumLeftPath + root.data;

		}
	}

	public static long findMaxSumPath(TreeNode root) {
		// Variable to store the maximum sum of path between two leaves for the given tree.
		Number maxPathSum = new Number(-1L);
		findMaxSumPathHelper(root, maxPathSum);
		return maxPathSum.num;
	}
}
