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



/*

	Representation of the Pair Class

	class Pair<T, U> {
		T minimum;
		U maximum;

		public Pair(T minimum, U maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}

*/
import java.util.*;
public class Solution {

	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
        
        if(root==null){
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            Pair<Integer, Integer> ans=new Pair<Integer, Integer>(min,max);
            return ans;
        }
        int rd=root.data;
       
        Pair<Integer, Integer> l=getMinAndMax(root.left);
        Pair<Integer, Integer> r=getMinAndMax(root.right);
        
        int max=Math.max(l.maximum,Math.max(r.maximum,rd));
        int min=Math.min(l.minimum,Math.min(r.minimum,rd));
            Pair<Integer, Integer> ans=new Pair<Integer, Integer>(min,max);
       
           return ans;
	}
	
}
