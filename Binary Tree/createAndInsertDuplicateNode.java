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
  

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null){
            return;
        } 
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        
        int data=root.data;
        
        BinaryTreeNode<Integer> newn=new BinaryTreeNode<Integer>(data);
        BinaryTreeNode<Integer> savel=root.left;
      
        root.left=null;
        
        root.left=newn;
        newn.left=savel;
        
        return;
        
        
	}
	
}
