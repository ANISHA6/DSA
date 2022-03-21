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
	public static void replace(TreeNode<Integer> root,int d){
        if(root==null){
            return;
        }
        root.data=d;
        for(int i=0;i<root.children.size();i++){
            replace(root.children.get(i),d+1);
        }
        
    }
	public static void replaceWithDepthValue(TreeNode<Integer> root){

		// Write your code here
        replace(root,0);
		
	}
	
	
}
