/*******************************************************

	Following is the BinaryTreeNode class structure:

	class BinaryTreeNode<T> {
    	T data;
    	BinaryTreeNode<T> left;
    	BinaryTreeNode<T> right;

    	public BinaryTreeNode(T data) {
        	this.data = data;
    	}
	}
	
*******************************************************/
import java.util.*;
public class Solution {
    static ArrayList<BinaryTreeNode<Integer>> arr=new ArrayList<>();
    public static void findinorder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        findinorder(root.left);
        arr.add(root);
        findinorder(root.right);
    
}
    
	public static BinaryTreeNode<Integer> inorderSuccesor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
    	// Write you code here.
        findinorder(root);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).equals(node)){
                if(i+1<arr.size()){
                return arr.get(i+1);}
            }
        }
        return null;
        
        
	}
}
