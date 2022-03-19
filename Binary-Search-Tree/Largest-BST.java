import java.util.*;
class IsBSTReturn{
    int min;
    int max;
    boolean isBST;
    int height;
    public IsBSTReturn(int min, int max, boolean isBST, int height){
        this.min=min;
        this.max=max;
        this.isBST=isBST;
        this.height=height;
    }
}

public class Solution {
    /*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
    public static IsBSTReturn bst(BinaryTreeNode<Integer> root){
        if(root==null){
            IsBSTReturn ans=new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE,true,0);
            return ans;
        }
        IsBSTReturn leftans=bst(root.left);
        IsBSTReturn  rightans=bst(root.right);

        int min=Math.min(root.data, Math.min(leftans.min, rightans.min));
        int max=Math.max(root.data, Math.max( leftans.max, rightans.max));

        int height=Math.max(leftans.height, rightans.height);

        boolean isBST=false;

        if(leftans.max<root.data && rightans.min>=root.data && leftans.isBST && rightans.isBST){
            isBST=true;
            height++;
            return new IsBSTReturn(min,max,isBST,height);
        }
       
        IsBSTReturn ans=new IsBSTReturn(min, max, isBST, height);
        return ans;


    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        IsBSTReturn ans=bst(root);
        return ans.height;
    }

}
