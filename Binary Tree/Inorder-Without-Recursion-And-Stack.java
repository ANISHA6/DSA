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
        public static void inOrder(BinaryTreeNode<Integer> root) {
            //Write your code here
            if(root==null){
                return;
            }
            BinaryTreeNode<Integer> temp=root;
            while(temp!=null){
                if(temp.left==null){//if left is null then print left data
                    System.out.print(temp.data+" ");
                    temp=temp.right;
                }
                else{
                    BinaryTreeNode<Integer> lef=temp.left;
                    while(lef.right!=null && lef.right!=temp){
                        lef=lef.right;//finding predecessor of current node
                    }
                    if(lef.right==null){
                        lef.right=temp;//before moving to left ,linking to current node with its predecessor, to go back
                        temp=temp.left;
                    }
                    else{
                        lef.right=null;
                        System.out.print(temp.data+" ");
                            temp=temp.right;
                    }
                }
            }
            
        }
        
    }
    
