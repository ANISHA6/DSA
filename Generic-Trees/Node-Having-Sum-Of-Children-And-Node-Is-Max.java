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
	
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		// Write your code here
        if(root==null){
            return null;
        }
        TreeNode<Integer> ans=root;
        int sum=root.data;
        for(int i=0;i<root.children.size();i++){
            sum+=root.children.get(i).data;
        }
        for(int i=0;i<root.children.size();i++){
         TreeNode<Integer> childa= maxSumNode(root.children.get(i));
            int cs=root.children.get(i).data;
            for(int j=0;j<root.children.get(i).children.size();j++){
                cs+=root.children.get(i).children.get(j).data;
                
            }
            if(cs>sum){
                ans=childa;
            }
        }
        return ans;
        
	}
	
		
}
