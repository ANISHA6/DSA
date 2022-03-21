public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		// Write your code here
        if(root1==null && root2==null){
            return true;
        }
        
        if(root1.children.size()==root2.children.size() && root1.data==root2.data){
            return true;
        }
       
        if(root1.children.size()==root2.children.size()){
        for(int i=0;i<root1.children.size() && i< root2.children.size();i++){
            if(checkIdentical(root1.children.get(i),root2.children.get(i))){
                return true;
            }
        }}else{
            return false;
        }
            return false;
        
	}
	
}
