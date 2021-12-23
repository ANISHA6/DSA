public class Solution {
    // Recursive solution
    public static int minCost(int[][] cost, int i,int j){
        TC:O(3^(M*N)) SC=Max(N,M)
        int r=cost.length;
        int c=cost[0].length;
        // Special case
        if(i==r-1 && j==c-1)
            return cost[i][j];
        if(i>=r || j>=c){
            return Integer.MAX_VALUE;
        }
        int a=minCost(cost,i+1,j);
        int b=minCost(cost,i,j+1);
        int d=minCost(cost,i+1,j+1);
        return cost[i][j]+Math.min(a, Math.min(b,d));
    
    }

	public static int minCostPath(int[][] input) {
		//Your code goes here
        //Using recursion
        return minCost(input,0,0);
  }
}
// Iterative solution
// TC:O(M*N), SC:O(M+N)
 int m=input.length;
        int n=input[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=input[i][j];
                    continue;
                }
                dp[i][j]=input[i][j]+(Math.min(dp[i+1][j], Math.min(dp[i][j+1],dp[i+1][j+1])));
                    
            
        }
                                      }
        return dp[0][0];
}


An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
