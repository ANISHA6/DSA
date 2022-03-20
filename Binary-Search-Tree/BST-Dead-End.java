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
    public static boolean helper(BinaryTreeNode<Integer> root, int min, int max){
        if(root==null){
            return false;
        }
        if(min==max){
            return true;
        }
        return helper(root.left, min, root.data-1) || helper(root.right, root.data+1, max);
            
        
        
    }

    public static boolean deadEnd(BinaryTreeNode<Integer> root) {
        //Write your code here
        return helper(root, 1, Integer.MIN_VALUE);
    }
        
}
    
