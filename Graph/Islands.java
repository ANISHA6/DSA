import java.util.*;
public class Solution {
    
    public static void helper(int[][] matrix, boolean[] visited, int start){
        Queue<Integer> q=new LinkedList<>();
      
        q.add(start);
        visited[0]=true;
        
        while(!q.isEmpty()){
            int cv=q.poll();
            for(int i=0;i<matrix.length;i++){
                if(matrix[cv][i]!=0 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
   }

	public static int numConnected(int[][] edges, int n) {
        
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
        
        int c=0;
        boolean[] visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
               
                helper(edges,visited,i);
                c++;
            }
        }
        return c;
	}


}
