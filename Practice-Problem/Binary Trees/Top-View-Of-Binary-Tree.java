/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
class Pair {
	BinaryTreeNode root;
	int level;

	Pair() {
	}

	Pair(BinaryTreeNode root, int level) {
		this.root = root;
		this.level = level;
	}
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
		ArrayList<Integer> ans = new ArrayList<>();
		if(root==null)
			return ans;
		// Map with key as horzontal distance and value as the tree node.
		HashMap<Integer, BinaryTreeNode> mp = new HashMap<>();

		Queue<Pair> q = new LinkedList<>();
		// Enqueue the root.
		Pair p1 = new Pair(root, 0);
		q.add(p1);
		while (!q.isEmpty()) {
			Pair p = q.poll();

			// Update the value for every horizontal distance.
			if(!mp.containsKey(p.level)){
			mp.put(p.level, p.root);
				
			}
			// If left child is present, push it.
			if (p.root.left != null) {
				q.add(new Pair(p.root.left, p.level - 1));
			}
			// If right child is present, push it.
			if (p.root.right != null) {
				q.add(new Pair(p.root.right, p.level + 1));
			}
		}
		ArrayList<Integer> topView = new ArrayList<>();

		for (int key : mp.keySet()) {
			topView.add(key);
		}
		// Sorting Keys according to the level Example (-2,-1,0,1,2).
		Collections.sort(topView);
		 // Store all final set of nodes in the answer vector.
			for (int i : topView) {
			ans.add(mp.get(i).val);
		}

		return ans;
		
		
	}
}
