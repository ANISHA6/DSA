import java.util.Scanner;

public class Solution {
    public static int findMinVertex(boolean[] visited, int[] distance){
        int minvertex=-1;
        for(int i=0;i<visited.length;i++){
            if(!visited[i] &&(minvertex==-1 || distance[i]<distance[minvertex])){
                minvertex=i;
            }
        }
        return minvertex;
    }
    public static void dijkstra(int[][] matrix){
        int n=matrix.length;
        boolean[] visited=new boolean[n];
        int[] distance=new int[n];
        distance[0]=0;
        for(int i=1;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int minvertex=findMinVertex(visited, distance);
            visited[minvertex]=true;
            
            for(int j=0;j<n;j++){
                if(matrix[minvertex][j]>0 && !visited[j] && matrix[minvertex][j]!=Integer.MAX_VALUE){
                    int newdist=distance[minvertex]+matrix[minvertex][j];
                    if(newdist<distance[j]){
                        distance[j]=newdist;
                    }
                    
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(i+" "+distance[i]);
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
            
            matrix[v2][v1]=w;
            matrix[v1][v2]=w;
        }
        dijkstra(matrix);
	}
}
