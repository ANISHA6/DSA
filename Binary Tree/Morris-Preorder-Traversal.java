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
        public static void preOrder(BinaryTreeNode<Integer> root) {
            //Write your code here
            
            if(root==null){
                return;
            }
            BinaryTreeNode<Integer> curr;
            curr=root;
            while(curr!=null){
                if(curr.left==null){
                    System.out.print(curr.data+" ");
                    curr=curr.right;
                }
                else{
                    BinaryTreeNode<Integer> lrm=curr.left;
                    while(lrm.right!=null && lrm.right!=curr){
                        lrm=lrm.right;
                    }
                    if(lrm.right==null){
                     
                        System.out.print(curr.data+" ");
                        lrm.right=curr;
                        curr=curr.left;
                    }
                    else{
                        lrm.right=null;
                        curr=curr.right;
                    }
                }
            }
            
        }
        
    }
    
