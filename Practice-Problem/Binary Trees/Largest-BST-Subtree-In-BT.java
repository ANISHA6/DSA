/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/
import java.util.*;
class NodeValue{
	int max;
	int min;
	int size;
	NodeValue(int max, int min, int size){
		this.max=max;
		this.min=min;
		this.size=size;
	}
}
public class Solution {
	public static NodeValue helper(TreeNode<Integer> root){
		if(root==null){
			return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		}
		NodeValue l=helper(root.left);
		NodeValue r=helper(root.right);
		
		if(l.max<root.data && r.min>root.data){
			return new NodeValue(Math.max(r.max, root.data), Math.min(root.data, l.min), (l.size+ r.size)+1);
		}
		
		return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,  Math.max(l.size, r.size));
	}
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
		return helper(root).size;
	}
}
