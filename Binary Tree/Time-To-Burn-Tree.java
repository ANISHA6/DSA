/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

import java.util.*;
class Triplet{
    int max, below, above;
    Triplet(int max, int above, int below){
        this.max=max;
        this.below=below;
        this.above=above;
    }
}

public class Solution
{
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start){
    
        // Write your code here
    Triplet ans=fun(root, start);
    return ans.max;
    
    }
    
    public static Triplet fun(BinaryTreeNode<Integer> root, int start){
        if(root==null){
            return new Triplet(-1,-1,0);
        }
        Triplet left=fun(root.left, start);
        Triplet right=fun(root.right, start);
        Triplet ans=new Triplet(-1,-1,0);
        
        //node is the starting node
        
        if(root.data==start){
            int below=Math.max(left.below, right.below);
            ans.max=below;
            ans.above=0;
            ans.below=below;
        }
        //starting node is in left subtree
        else if(left.above!=-1){
            ans.max=Math.max(left.max, Math.max(left.below, left.above+right.below+1));
            ans.above=left.above+1;
            ans.below=left.below;
        }
        
        //starting node is in right subtree
        
        else if(right.above!=-1){
            ans.max=Math.max(right.max, Math.max(right.below, right.above+left.below+1));
            ans.above=right.above+1;
            ans.below=right.below;
            
        }
        // starting node doesn't exist in the subtree
        else{
            ans.max=-1;
            ans.above=-1;
            ans.below=Math.max(left.below, right.below)+1;
            
        }
        
        return ans;
        
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
