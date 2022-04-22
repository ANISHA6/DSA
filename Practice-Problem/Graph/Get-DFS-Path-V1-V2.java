/*
    Time Complexity : O(V+E)
    Space Complexity : O(V)

    Where V is the number of nodes and E is the number of edges in the graph
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Solution {

    static int dfs(int node, int end, HashMap<Integer,  ArrayList<Integer>> adj, int []parent, int par, int start) {
        // If current node is end node return true.
        if (node == end) {
            parent[node] = par;
            return 1;
        }
    
        // Update parent of the current node.
        parent[node] = par;
        int ans = 0;
        
        if(adj.get(node)==null)
        {
            return 0;
        }
    
        // Iterate all the nodes connected to the current node.
        for (int i = 0; i < adj.get(node).size(); i++) {
            int curr = adj.get(node).get(i);
    
            // Avoid revisiting the nodes.
            if (curr == par || curr == start) {
                continue;
            }
            if (parent[curr] != -1) {
                continue;
            }
    
            // If we found the end node return true.
            ans = ans | dfs(curr, end, adj, parent, node, start);
            if (ans==1) {
                return ans;
            }
        }
        return ans;
    }
    

    static ArrayList<Integer> getPath(int V, int E, ArrayList<Integer> a, ArrayList<Integer> b, int v1, int v2) {
    // Initialize a vector to store the parent of all the nodes.
    int[] par=new int[V];
    Arrays.fill(par, -1);

    // Map of List to store all the edges.
    HashMap<Integer,  ArrayList<Integer>> graph= new HashMap<>();
    for (int i = 0; i < a.size(); i++) {

        if(graph.get(a.get(i))==null)
        {
            graph.put(a.get(i),new ArrayList<Integer>());
        }

        if(graph.get(b.get(i))==null)
        {
            graph.put(b.get(i),new ArrayList<Integer>());
        }


        graph.get(a.get(i)).add(b.get(i));
        graph.get(b.get(i)).add(a.get(i));
    }

    // List to store the final answer.
    ArrayList<Integer> ans=new ArrayList<>();

    // If the first node is the last node return first node only.
    if (v1 == v2) {
        ans.add(v2);
        return ans;
    }

    /*
        Check if there is a possible path using dfs and
        also update the parent vector.
    */
    int possible = dfs(v1, v2, graph, par, -1, v1);

    // If no path exist return empty list.
    if (possible==0) {
        return ans;
    }

    int k = v2;

    /*
        Iterate in the parent array from the end
        node till you reach the starting node.
    */
    while (k != -1) {
        ans.add(k);
        k = par[k];
    }

    return ans;
       
    }
    
}
