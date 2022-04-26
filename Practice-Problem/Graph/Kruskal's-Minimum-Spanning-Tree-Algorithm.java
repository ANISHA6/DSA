import java.util.*;

/*
    Time Complexity: O(M * log(M) + N + M)
    Space Complexity: O(N + M)

    Where 'N' and 'M' denotes the number of nodes and edges in the graph, respectively.
*/

class SortCompare implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(2).compareTo(b.get(2));
    }
}
public class Solution {
	public static int findParent(int vertex, int[] p){
		if(vertex==p[vertex]){
			return vertex;
		}
		return p[vertex]=findParent(p[vertex], p);
			
		
		}
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.

        Collections.sort(graph, new SortCompare());
		
		
		//Method 1, used disjoint set ds
	 int[] parent = new int[n + 1];
    int[] rank = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      rank[i] = 1;
      parent[i] = i;
    }

		int j=0;
		int c=0;
		int w=0;
    while (c!=n-1) {
   			ArrayList<Integer> currE=graph.get(j++);
 int p1 = findParent(currE.get(0), parent);
      int p2 = findParent(currE.get(1), parent);

      if (p1 != p2) {
		  c++;
		  w+=currE.get(2);
        if (rank[p1] < rank[p2]) {
          parent[p1] = p2;
        } else if (rank[p1] > rank[p1]) {
          parent[p2] = p1;
        } else {
          parent[p1] = p2;
          rank[p2]++;
        }
      }
	}
		return w;
		
		//Method 2
		int[] p=new int[n+1];
		for(int i=0;i<=n;i++){
			p[i]=i;
		}
		
	int w=0;
		int c=0;
		int j=0;
		while(c!=n-1){
			ArrayList<Integer> currE=graph.get(j++);
			int v1P=findParent(currE.get(0), p);
			int v2P=findParent(currE.get(1),p);
			if(v1P!=v2P){
// 				mst.add(currE);
				w+=currE.get(2);
				c++;
				p[v1P]=v2P;
			}
		}
							   return w;
		
    }
}
