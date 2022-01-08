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
    public static void helper(BinaryTreeNode<Integer> root, String ans, int sum,int k){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            sum+=root.data;
            if(sum==k){
                System.out.println(ans+root.data);
                
            }
           // return;
        }
        helper(root.left,ans+root.data+" ",sum+root.data,k);
        helper(root.right,ans+root.data+" ",sum+root.data,k);
        
    }

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        
		//Your code goes here
        if(root==null){
            return ;
        }
        helper(root, "",0,k);
	}

}
