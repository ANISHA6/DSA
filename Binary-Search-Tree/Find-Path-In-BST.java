import java.util.ArrayList;

public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 * 		public BinaryTreeNode(T data) 
	 * 		{ 
	 * 			this.data = data; 
	 * 		}
	 * }
	 */

	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        
        
        if(root==null){
            return null;
        }
        if(root.data==data){
            ArrayList<Integer> ans=new ArrayList<Integer>();
            ans.add(data);
            return ans;
        }
        
        ArrayList<Integer> lo=getPath(root.left, data);
        if(lo!=null){
            lo.add(root.data);
            return lo;
        }
         ArrayList<Integer> ro=getPath(root.right,data);
        if(ro!=null){
            ro.add(root.data);
            return ro;
        }

        
        }
}
