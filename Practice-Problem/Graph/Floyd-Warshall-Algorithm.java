
/*
    Time complexity: O(N^3)
    Space complexity: O(N^2)

    where 'N' is the number of vertices in the graph.
*/

import java.util.ArrayList;

public class Solution {

    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

        // Stores the shortest path between two vertices.
        int[][] d = new int[n + 1][n + 1];

        // Initialize all the values to 1e9 except i, i which initializes to 0.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = 1000000000;
                }
            }
        }
        // Add all edges to the matrix.
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            d[u][v] = w;
        }

        // Apply Flloyd Warshall's Algorithm.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] != 1000000000 && d[k][j] != 1000000000) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }

        // Return dist between src and dest.
        return d[src][dest];

    }

}


Floyd-Warshall's Algorithm
We will create a 2D array ‘D[][]’, where ‘D[i][j]’ stores the shortest distance from vertex ‘i’ to vertex ‘j’.
Initialize the 2D array with an infinite value.
Iterate on the vertices 1 to ‘N’, initialize ‘D[i][i]’ with 0.
Iterate on the edges of the graph, and each edge (‘u’,’v’,’w’) update ‘D[u][v]’, i.e., ‘D[u][v]’ = ‘w’.
Now we will use Dynamic Programming to find the minimum distance between every pair of vertices.
For(k: 1 to ‘N’){
    For(i: 1 to ‘N’){
        For(j: 1 to ‘N’){
            ‘D[i][j]’ = min(‘D[i][j]’, ‘D[i][k]’ + ‘D[k][j]’)
        }
    }
}
 

Time Complexity
O(N^3), where ‘N’ is the number of vertices in a graph 

 

We are iterating on the edges of the graph which will take O(M) time. We are iterating on the vertices and for each vertex, we are considering every possible pair of vertices, so it will take O(N^3) time. Thus, the final time complexity will be O(N * N * N + M + N) = O(N^3 + M) = O(N^3) [Since, the maximum value of M can be N^2].

Space Complexity
O(N^2), where ‘N’ is the number of vertices in a graph.

 

 We are making a 2D array ‘D’ which will take O(N^2) extra space.


