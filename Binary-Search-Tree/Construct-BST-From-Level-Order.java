import java.util.*;

public class Solution {

    /*	Binary Tree Node class
       
       class BinaryTreeNode<T> {
            T data;
            BinaryTreeNode<T> left;
            BinaryTreeNode<T> right;
            
            public BinaryTreeNode(T data) {
                this.data = data;
            }
        }

    */
    public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root, int value){
        if(root==null){
            BinaryTreeNode<Integer> node=new BinaryTreeNode<Integer>(value);
            return node;
        }if(value<=root.data){
            root.left=helper(root.left,value);
        }
        else{
            root.right=helper(root.right,value);
        }
        return root;
        
    }

    public static BinaryTreeNode<Integer> constructBST(int[] preorder, int n) {
        //Write your code here
        
        if(n==0){
            return null;
        }
        BinaryTreeNode<Integer> root=null;
        for(int i=0;i<n;i++){
            root=helper(root,preorder[i]);
        }
        return root;
    }
        
}
    
