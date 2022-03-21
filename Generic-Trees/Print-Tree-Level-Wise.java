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
	
	
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        
        if(root==null){
            return;
        }
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode<Integer> takefq=queue.poll();
            if(takefq!=null){
                System.out.print(takefq.data+" ");
                for(int i=0;i<takefq.children.size();i++){
                    queue.add(takefq.children.get(i));
                }
            }
            else{
                if(queue.isEmpty()){
                    return;
                }
                else{
                queue.add(null);
                System.out.println();
            }
            }
            
        }
        return;

	}
		
}
