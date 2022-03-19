import java.util.*;
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
	static ArrayList<Integer> arr=new ArrayList<>(); 
    public static void getinorder(BinaryTreeNode<Integer> root ,ArrayList<Integer> arr) {
        if(root==null){
            return ;
        }
        getinorder(root.left,arr);
        arr.add(root.data);
        getinorder(root.right,arr);
        
        
    }
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		// Write your code here
        // find inorder then find the pair by traversing both side.
        getinorder(root,arr);
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            int l=arr.get(i);
            int r=arr.get(j);
            if(l+r>s){
                j--;
            }
            else if(l+r<s){
                i++;
            }
            else{
                System.out.print(l+" "+ r);
                i++;
                j--;
            }
            System.out.println();
        }
    }

}
