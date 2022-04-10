
import java.util.*;
import java.util.Scanner;

// Steps  to write the krusskal's algorithum
//     1.Take i/p in array of type Edge class(Edge class has v1, v2 and weight b/w v1 and v2), TC:O(E)

//     2. Implement Comparable class with Edge class to sort the weight of Edge class
//     3. Comparable class has compareTo method, so write code to sort the weight, TC:O(ElogE)
//     4. To keep track of wether this edge we should include or not , we have to use has path or union find alorithum
//     but here we will use union find algorithm due to its less time complexity,
//     for it we have to write findParent() method, TC:O(EV)
//     5. For the output we have to store all the edges in array of type Edge
    
    
    //Edge class for storing the edge with weight
class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;
    Edge(int v1, int v2, int weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
    public int compareTo(Edge o){
        return this.weight-o.weight;
    }
    
    
}

public class Solution {
    //Union find algorithm
    public static int findparent(int v, int parent[]){
        if(v==parent[v]){
            return v;
        }
        return findparent(parent[v],parent);
    }
    
    //kruskal's Algorithm for building the minimum spanning tree
    public static Edge[] kruskalAlgorithm(Edge[] edges, int n){
        
        Arrays.sort(edges);
        Edge mst[]=new Edge[n-1];
        int parent[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            
        }
        int count=0, j=0;
        while(count!=n-1){
            Edge curre=edges[j];
            j++;
            int v1p=findparent(curre.v1,parent);
            int v2p=findparent(curre.v2, parent);
            if(v1p!=v2p){
                mst[count]=curre;
                count++;
                parent[v1p]=v2p;
            }
        }
        return mst;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
         
         Edge edges[]=new Edge[E];
         for(int j=0;j<E;j++){
         int v1=sc.nextInt();
         int v2=sc.nextInt();
         int w=sc.nextInt();
         Edge curre=new Edge(v1, v2,w);
         edges[j]=curre;
         }
         Edge mst[]=kruskalAlgorithm(edges,V);
        
        //printing the output//Edge class for storing the edge with weight
         for(int i=0;i<mst.length;i++){
         if(mst[i].v1<mst[i].v2){
         System.out.println(mst[i].v1+" "+ mst[i].v2+" "+mst[i].weight);
         }else{
         System.out.println(mst[i].v2+" "+ mst[i].v1+" "+mst[i].weight);
         
         }
         }
	}
}
