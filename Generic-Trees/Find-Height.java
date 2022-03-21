import java.util.*;
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

	public static int getHeight(TreeNode<Integer> root){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        
        //No. of levels, equal to height of the tree
        if(root==null){
            return 0;
        }
        int h=0;
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode<Integer> n=q.poll();
            if(n!=null){
                for(int i=0;i<n.children.size();i++){
                    q.add(n.children.get(i));
                    }
              }
            else{
                h++;
                if(!q.isEmpty()){
                    q.add(null);
                }
                else 
                    break;
            }
        }
        return h;
	}

}
