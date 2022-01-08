/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {
    public static void change(BinaryTreeNode<Integer> root,int k){
        if(root==null){
            return;
        }
        root.data=k;
        change(root.left,k+1);
        change(root.right,k+1);
        return;
    }
    

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
         change(root,0);
        return;
	}

}
