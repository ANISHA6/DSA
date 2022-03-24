import java.util.*;
public class Solution {

    /*	Binary Tree Node class
     * 
     * class BinaryTreeNode<T> {
            T data;
            BinaryTreeNode<T> left;
            BinaryTreeNode<T> right;
            
            public BinaryTreeNode(T data) {
                this.data = data;
            }
        }
        */
    static int t=0;
public static int getTil(BinaryTreeNode<Integer> root) {
            //Write your code here
     
          if(root==null){
            return 0;
        }
        int l=getTil(root.left);
        int r=getTil(root.right);
        t+=Math.abs(l-r);
    
        return l+r+root.data;
}
        public static int getTilt(BinaryTreeNode<Integer> root) {
            //Write your code here

          getTil(root);
            return t;
            
        }
        
    }
    
