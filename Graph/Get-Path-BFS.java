import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static ArrayList<Integer> getpath(int[][] matrix, int v1, int v2){
         Queue<Integer> q=new LinkedList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=matrix.length;
        boolean visited[]=new boolean[n];
        
        visited[v1]=true;
        q.add(v1);
        map.put(v1,-1);
        boolean pathfound=false;
        
        while(!q.isEmpty()){
            int cv=q.poll();
            
            for(int i=0;i<n;i++){
            
            if(matrix[cv][i]==1 && !visited[i]){
                q.add(i);
                visited[i]=true;
                map.put(i,cv);
                if(i==v2){
                    pathfound=true;
                    break;
                }
                
            }
            }}
        ArrayList<Integer> path=new ArrayList<>();
        if(pathfound){

            int cv=v2;
            while(cv!=-1){
                path.add(cv);
                int parent=map.get(cv);
                cv=parent;
            }
            return path; 
        }else{
            return path;
        }
        
        
    }
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
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
        int s=sc.nextInt();
            int d=sc.nextInt();
        
        ArrayList<Integer> ans=getpath(matrix,s,d);
        for(int i:ans){
            System.out.print(i+" ");
        }
        
	}
}
