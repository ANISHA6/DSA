import java.util.*;

public class Solution {

    /* Structure of BinaryTreeNode class is:

        class BinaryTreeNode<T> {
		    T data;
		    BinaryTreeNode<T> left;
		    BinaryTreeNode<T> right;

		    public BinaryTreeNode(T data) {
			    this.data = data;
		    }
	    }
    
    */
    static int ans;
    static int min;
    public static void helper(BinaryTreeNode<Integer> root, int k){
        if(root==null){
            return;
        }if(k==root.data){
            ans=k;
            min=0;
            return;
        }
        if(min>Math.abs(k-root.data)){
            min=Math.abs(k-root.data);
            ans=root.data;
        }
        if(k>root.data){
            helper(root.right,k);
        }else
            helper(root.left,k);
        
 }

    public static int minDiff(BinaryTreeNode<Integer> root, int k) {
        //Write your code here
        min=Integer.MAX_VALUE;
        ans=-1;
        helper(root,k);
        return ans;
        
    }
        
}
    
