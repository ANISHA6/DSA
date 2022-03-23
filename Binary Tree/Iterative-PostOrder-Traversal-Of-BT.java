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
        public static void postOrder(BinaryTreeNode<Integer> root) {
            //Write your code here
            if(root==null){
                return;
            }
            //Using two stacks
            //use concept of modified version of preorder
            
           Stack<BinaryTreeNode<Integer>> s1=new Stack<>();
            Stack<BinaryTreeNode<Integer>> s2=new Stack<>();
            s1.push(root);
            BinaryTreeNode<Integer> curr=root;
            while(!s1.isEmpty()){
        
                    BinaryTreeNode<Integer> t=s1.pop();
                    s2.push(t);
                
                if(t.left!=null){//first we want right that's why pushing left
                    s1.push(t.left);
                }
                if(t.right!=null){
                    s1.push(t.right);
                }
            }
            //s2 will give the final ans
            //s2 is nothing but reverse of modified preorder
            //preorder=RootLR, modified-preorder=RootRL
            while(!s2.isEmpty()){
                System.out.print(s2.pop().data+" ");
            }
            
            
            
            
            
            //Using one stack
            //first go left....
            //then right left
            Stack<BinaryTreeNode<Integer>> st=new Stack<>();
            BinaryTreeNode<Integer> curr=root;
            while(curr!=null || !st.isEmpty()){
               if(curr!=null){
                   st.push(curr);
                   curr=curr.left;
               }else{
                   BinaryTreeNode<Integer> temp=st.peek().right;
                   if(temp==null){
                       temp=st.pop();
                       System.out.print(temp.data+" ");
                       while(!st.isEmpty() && temp==st.peek().right){
                           temp=st.pop();
                       System.out.print(temp.data+" ");
                           
                           
                       }
                   }else
                       curr=temp;
               }
            }
        }
        
    }
    
