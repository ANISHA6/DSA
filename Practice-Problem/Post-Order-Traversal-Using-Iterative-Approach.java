
/*
	Time Complexity: O(N)
	Space Complexity: O(N)
	
	where N is the number of nodes in tree
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {

	public static ArrayList<Integer> postorderTraversal(BinaryTreeNode<Integer> root) {
	
		// Declaring stack to maintain the order of traversal
	    Stack<BinaryTreeNode<Integer>> nodeStack= new Stack<>();

	    // Declaring ans array to store the postorder traversal
	    ArrayList<Integer> ans =new ArrayList<>();

	    nodeStack.push(root);

	    while (nodeStack.size() > 0)
	    {
	        // Deleting the top node of nodeStack
	        BinaryTreeNode<Integer> cur = nodeStack.pop();

	        // Inserting cur node's value into ans.
	        ans.add(cur.data);

	        // If left child is not empty,insert it into nodeStack
	        if(cur.left != null)
	        {
	            nodeStack.push(cur.left);
	        }

	        // If right child is not empty,insert it into nodeStack
	        if(cur.right != null)
	        {
	            nodeStack.push(cur.right);
	        }
	    }

	    // Reverse the answer array
	    Collections.reverse(ans);
	    return ans;
	}

}
