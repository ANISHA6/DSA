/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/
import java.util.*;
public class Solution {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
        
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> alle=new LinkedList<BinaryTreeNode<Integer>>();
        alle.add(root);
        while(!alle.isEmpty()){
            System.out.print(alle.peek().data+":");
            if(alle.peek().left!=null){
                alle.add(alle.peek().left);
                System.out.print("L:"+alle.peek().left.data);
            }
            else
                System.out.print("L:-1");
            if(alle.peek().right!=null){
                alle.add(alle.peek().right);
                System.out.print(",R:"+alle.peek().right.data);
            }
            else
                System.out.print(",R:-1");
            
        
        System.out.println();
        alle.poll();
        }
	}
	
}
