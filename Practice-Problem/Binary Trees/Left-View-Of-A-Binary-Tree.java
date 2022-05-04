/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };
	
	
	 Time Complexity - O(N)
    Space Complexity - O(N) or O(H)

    Where N is the number of nodes in the Binary Tree.

************************************************************/

import java.util.ArrayList;

public class Solution 
{
	//used preorder traversal
	public static void helper(ArrayList<Integer> list, TreeNode<Integer> root, int l){
		if(root==null){
			return;
		}
		if(list.size()==l){// Logic is that, insert if size of DS is equal to level
			list.add(root.data);//storing becoz, 1st node of every level  will be visible from left side
		}
		helper(list, root.left, l+1);
		helper(list, root.right, l+1);
		
	}
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
		ArrayList<Integer> list=new ArrayList<Integer>();
		helper(list, root, 0);
		return list;
		
    }
}
