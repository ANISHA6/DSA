public class Solution {

	/*	Binary Tree Node class 
	 * 
	 * 	class BinaryTreeNode<T> {
			T data;
			BinaryTreeNode<T> left;
			BinaryTreeNode<T> right;
			
			public BinaryTreeNode(T data) {
				this.data = data;
			}
		}
		*/
    public static BinaryTreeNode<Integer> helper(int[] arr, int left, int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        BinaryTreeNode<Integer> curr=new BinaryTreeNode<>(arr[mid]);
        curr.left=helper(arr,left, mid-1);
        curr.right=helper(arr, mid+1, right);
        return curr;
    }
    
	
		public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
            if(n==0){
                return null;
            }
            
             return helper(arr, 0, n-1);
    }
}
