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
  //  import java.util.*;
     static ArrayList<Integer> arr=new ArrayList<>();
    public static void findinorder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        findinorder(root.left);
        arr.add(root.data);
        findinorder(root.right);
    
}

    public static int median(BinaryTreeNode<Integer> root) {
        //Write your code here
        findinorder(root);
        int n=arr.size();
        if(n%2==0){
            return (arr.get(n/2-1)+arr.get(n/2))/2;
        }
                    return arr.get(n/2);
    }
        
}
    
