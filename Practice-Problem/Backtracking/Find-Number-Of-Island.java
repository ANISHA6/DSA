//using DFS

public class Solution 
{
    public static void dfs(int i, int j,int n, int m, int[][] vis, int[][] mat){
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }
        if(mat[i][j]==0)
            return;
        
        if(vis[i][j]!=1 ){
            vis[i][j]=1;
            //Checking for all 8 directions.
            dfs(i-1, j, n, m, vis, mat);
            dfs(i+1, j, n, m, vis, mat);
            dfs(i, j-1, n, m, vis, mat);
            dfs(i, j+1 ,n, m, vis, mat);
            dfs(i+1, j-1, n, m, vis, mat);
            dfs(i-1, j+1, n, m, vis, mat);
            dfs(i+1, j+1, n, m, vis, mat);
            dfs(i-1, j-1, n, m, vis, mat);
            
        }
    }
    public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=0;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && mat[i][j]==1){
                    dfs(i, j, n, m, vis, mat);
                    ans++;
                }
            }
        }
        return ans;
    }
}

//Flood fill algorithm

/*
    Time Complexity: O(N * M)
    Space Complexity: O(N * M)

    Where N and M are the number of rows and columns of the 2D array, respectively.
*/

import java.util.ArrayList;

public class Solution 
{

    private static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    /*
        dx[] and dy[] are the arrays that define each of the eight directions.

        dx[0], dy[0] : West
        dx[1], dy[1] : North-West
        dx[2], dy[2] : North
        dx[3], dy[3] : North-East
        dx[4], dy[4] : East
        dx[5], dy[5] : South-East
        dx[6], dy[6] : South
        dx[7], dy[7] : South-West

    */

    private static ArrayList<ArrayList<Boolean>> vis = new ArrayList<>();

    private static void getTotalIslandsHelper(int[][] mat, int n, int m, int x, int y) 
	{

        // Check if this cell is valid.
        if(!(x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1 && !vis.get(x).get(y))) 
		{
            return; 
        }

        vis.get(x).set(y, true);

        for(int i = 0; i < 8; i++) 
		{
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            getTotalIslandsHelper(mat, n, m, nextX, nextY);
        }
    }

    public static int getTotalIslands(int[][] mat) 
	{
        int n = mat.length;
        if (n == 0) 
		{
            return 0;
        }
        int m = mat[0].length;
        for (int i = 0; i < n; i++) 
		{    
            vis.add(new ArrayList<>());
            ArrayList<Boolean> list = vis.get(i);
            for(int j = 0; j < m; j++) 
			{
                list.add(false);
            }
        }

        int islands = 0;

        for(int i = 0; i < n; i++) 
		{
            for(int j = 0; j < m; j++) 
			{
                if(mat[i][j] == 1 && !vis.get(i).get(j)) 
				{
                    // We have found an undiscovered island.
                    islands++;
                    getTotalIslandsHelper(mat, n, m, i, j);
                }
            }
        }

        return islands;
    }

}
