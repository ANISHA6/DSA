import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    
    
//Using  DFS
//     public static boolean path1(int[][] matrix, int v1, int v2, boolean[] visited ){
//         if(v1==v2){
//             return true;
//         }
        
//         visited[v1]=true;
//         boolean ans=false;
        
//         for(int i=0;i<matrix.length;i++){
//             if(matrix[v1][i]==1 && !visited[i]){
//               ans=path1(matrix, i, v2, visited);
//             }
//         }
//         return ans;
        
//     }
    
    
    //Using BFS
    public static boolean path(int[][] matrix, int v1, int v2){
         Queue<Integer> q=new LinkedList<>();
        int n=matrix.length;
        boolean visited[]=new boolean[n];
        
        visited[v1]=true;
        q.add(v1);
        while(!q.isEmpty()){
            int cv=q.poll();
            if(cv==v2){
                return true;
            }
     
            for(int i=0;i<n;i++){
            
            if(matrix[cv][i]==1 && !visited[i]){
                q.add(i);
                visited[i]=true;
            }
            }}
        return false;
        
        
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] matrix=new int[v][v];
        
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            matrix[v1][v2]=1;
            matrix[v2][v1]=1;  
        }
        int v1=sc.nextInt();
            int v2=sc.nextInt();
        
        System.out.print(path(matrix,v1,v2));
        
        
//         boolean visited[]=new boolean[v];
        
//         System.out.print(path1(matrix,v1,v2, visited));
        
        
	}

}
