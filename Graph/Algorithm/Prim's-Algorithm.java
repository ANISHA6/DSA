import java.util.*;
import java.util.Scanner;


//we use prim's algorithm to build minimum spanning tree

public class Solution {
  //Finding the unvisited vertex with minimum weight
    private static int findMinVertex(boolean[] visited, int[] weight){
        
        int minvertex=-1;
        for(int i=0;i<visited.length;i++){
            if(!visited[i] &&(minvertex==-1 || weight[i]<weight[minvertex])){
                minvertex=i;
            }
        }
        return minvertex;
    }
    public static void prims(int[][] matrix){
        
        int n=matrix.length;
        boolean[] visited=new boolean[n];
        int[] parent=new int[n];
        int[] weight=new int[n];
        parent[0]=-1;//Initializing parent of source node with -1
        weight[0]=0;//Weight of source node is zero
        
      //Initializing weight for rest of node with infinity
        for(int i=1;i<n;i++){
            weight[i]=Integer.MAX_VALUE;        
    }
    for(int i=0;i<n;i++){
        int minvertex=findMinVertex(visited, weight);
        visited[minvertex]=true;
    
        //Exploring all the adjacent vertex of minvertex
        for(int j=0;j<n;j++){
            if(matrix[minvertex][j]!=0 && !visited[j]){
                if(weight[j]>matrix[minvertex][j]){
                    weight[j]=matrix[minvertex][j];
                    parent[j]=minvertex;
                }
            }
        }}
        // print mst
        for(int i=1;i<n;i++){
            if(i<parent[i]){
                System.out.println(i+" "+parent[i]+" "+weight[i]);
            }else
                System.out.println(parent[i]+" "+i+" "+weight[i]);
        }
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        int[][] matrix=new int[V][V];
        for(int i=0;i<E;i++){
            int v1=s.nextInt();
            int v2=s.nextInt();
            int w=s.nextInt();
            matrix[v1][v2]=w;
            matrix[v2][v1]=w;
        }
        prims(matrix);
	}
}
