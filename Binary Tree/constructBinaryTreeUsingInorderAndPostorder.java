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
    public static BinaryTreeNode<Integer> helper(int[] post, int[] in,int sipost,int eipost,int siin,int eiin){
        
        if(sipost>eipost){
            return null;
        }
        int rootData=post[eipost];
         BinaryTreeNode<Integer> root=new  BinaryTreeNode<Integer>(rootData);
        
        int rooti=-1;
        for(int i=siin;i<=eiin;i++){
            if(in[i]==rootData){
                rooti=i;
                break;
            }
        }
        
        int sipostleft=sipost;
        int eipostright=eipost-1;
        int siinleft=siin;
        int eiinright=eiin;
        int eiinleft=rooti-1;
        int siinright=rooti+1;
        
        int l=eiinleft-siinleft+1;
        
        int eipostleft=sipostleft+l-1;
        int sipostright=eipostleft+1;
        
        

         BinaryTreeNode<Integer> left=helper(post,in,sipostleft,eipostleft,siinleft,eiinleft);
         BinaryTreeNode<Integer> right=helper(post,in,sipostright,eipostright,siinright,eiinright);
        
        root.left=left;
        root.right=right;
        
        return root;
        
        
        
    }
    

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
        
        return helper(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);
	}

}
