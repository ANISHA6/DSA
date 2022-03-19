import java.util.*;
import java.util.ArrayList;

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
	/*
	 * LinkedListNode Class
	 * class LinkedListNode<T> 
	 * { 
	 * 		T data; 
	 * 		LinkedListNode<T> next;
	 * 		public LinkedListNode(T data) 	
	 * 		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
        
        ArrayList<LinkedListNode<Integer>> arr=new ArrayList<LinkedListNode<Integer>>();
        if(root==null){
            return arr;
        }
        LinkedListNode<Integer> head=null;
        LinkedListNode<Integer> tail=null;
        
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
         if(q.peek()==null){
                  q.poll();
             arr.add(head);
             head=null;
             tail=null;
                if(!q.isEmpty()){
                  q.add(null);
                  
                          }
             else{
                 return arr;
             }
              }
            else{
                BinaryTreeNode<Integer> node=q.poll();
                LinkedListNode<Integer> newnode=new LinkedListNode<>(node.data);
                if(head==null){
                    head=newnode;
                    tail=newnode;
                }
                else{
                    tail.next=newnode;
                    tail=newnode;
                }
            if(node.left!=null){
            q.add(node.left);}
            if(node.right!=null){
                q.add(node.right);
            }
        
        }   }
        return arr;
        
	}

}
