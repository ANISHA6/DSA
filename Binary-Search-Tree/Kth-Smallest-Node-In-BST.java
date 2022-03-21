import java.util.*;
public class Solution {
    static ArrayList<Integer> arr=new ArrayList<>();
    public static void helper(BinaryTreeNode<Integer> root,int K){
        if(root==null){
            return ;
        }
        helper(root.left,K);
        arr.add(root.data);
        helper(root.right,K);
        
        
        
    }

	public static int kthSmallestNode(BinaryTreeNode<Integer> root,int K){
		// Write your code here
        helper(root,K);
        for(int i=0;i<arr.size();i++){
            if(K-1==i){
                return arr.get(i);
            }
        }
        return Integer.MIN_VALUE;
        
        
		
	}
}
