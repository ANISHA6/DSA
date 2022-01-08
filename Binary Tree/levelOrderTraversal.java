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
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
         if(q.peek()==null){
                  q.poll();
                if(!q.isEmpty()){
                  q.add(null);
                  System.out.println();
                          }
              }
            else{
            System.out.print(q.peek().data+" ");
                BinaryTreeNode<Integer> next=q.poll();
            if(next.left!=null){
               q.add(next.left);
            }
            if(next.right!=null){
                q.add(next.right);
            }
        
        }   }
    }
	
}

//Instead of printing , store and return the list

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
         
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){    
            TreeNode front; 
            if(queue.peek() != null){
                front = queue.poll();
                list.add(front.val);

                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            } else{
                ans.add(list);
                list = new LinkedList<>();
                queue.remove();
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
            }  
        }
        
        return ans;
    }
}
