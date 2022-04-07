import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void bft(int[][] matrix, int j, boolean[] visited){
        
        Queue<Integer> q=new LinkedList<>();
        int n=matrix.length;

        
        visited[j]=true;
        q.add(j);
        while(!q.isEmpty()){
            int cv=q.poll();
            System.out.print(cv+" ");
            for(int i=0;i<n;i++){
            
            if(matrix[cv][i]==1 && !visited[i]){
                q.add(i);
                visited[i]=true;
            }
            }
        }
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
         boolean visited[]=new boolean[v];
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                bft(matrix,i,visited);
            }
        }
       
        
        
	}

}
