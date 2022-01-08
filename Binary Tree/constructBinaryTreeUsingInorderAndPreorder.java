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
//Points to construct the tree
//1. Find the root
//2. find pre and inorder of left subtree and right subtree
//3. use recursion to build left and right subtree
//4. attached left and right subtree to the left
public class Solution {
    public static BinaryTreeNode<Integer> helper(int[] pre, int[] in, int siPre,int eiPre ,int siIn,int eiIn){
        
        if(siPre>eiPre){
            return null;
        }
        int rootData=pre[siPre];
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
        
        int rooti=-1;
        for(int i=siIn;i<=eiIn;i++){
            if(in[i]==rootData){//Finding root node index in inorder 
                rooti=i;
                break;
            }
        }
        
        int siPreLeft=siPre+1;
        int eiPreRight=eiPre;
        int eiInRight=eiIn;
        int siInLeft=siIn;
        int eiInLeft=rooti-1;
        int siInRight=rooti+1;
        
        int lengthOfl=eiInLeft-siInLeft+1;//left subtree length
        
        int eiPreLeft=siPreLeft+lengthOfl-1;
        int siPreRight=eiPreLeft+1;
        
        BinaryTreeNode<Integer> left=helper(pre, in,siPreLeft, eiPreLeft,siInLeft,eiInLeft);
        BinaryTreeNode<Integer> right=helper(pre,in,siPreRight,eiPreRight,siInRight,eiInRight);    
            
        root.left=left;
        root.right=right;
        return root;
        
        
    }

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
       return helper(preOrder, inOrder,0, preOrder.length-1, 0,inOrder.length-1);
        
	}

}
