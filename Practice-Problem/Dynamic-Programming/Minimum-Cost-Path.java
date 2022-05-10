//using recursion,  Error-TLE

/*
    Time Complexity: O(3 ^ (X * Y))
    Space Complexity: O(X + Y)

    where X and Y represent the coordinates of the destination cell.
 */

public class Solution 
{

	private static int minCostPathHelper(int[][] cost, int n, int m, int x, int y) 
    {
		if (x == 1 && y == 1) 
        {
			return cost[0][0];
		}

		int minCost = Integer.MAX_VALUE;

		if ((x - 1) > 0) 
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x - 1, y));
		}

		if ((y - 1) > 0) 
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x, y - 1));
		}

		if ((x - 1) > 0 && (y - 1) > 0) 
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x - 1, y - 1));
		}

		return minCost;
	}

	public static int minCostPath(int[][] cost, int x, int y) 
    {
		int n = cost.length;
		if (n == 0) 
        {
			return Integer.MAX_VALUE;
		}

		int m = cost[0].length;
		return minCostPathHelper(cost, n, m, x, y);

	}

}

//Using memoization
/*
    Time Complexity: O(X*Y)
    Space Complexity: O(X*Y)

    where X and Y represent the coordinates of the destination cell.
 */

import java.util.Arrays;

public class Solution 
{

	private static int minCostPathHelper(int[][] cost, int n, int m, int x, int y, int[][] dp) 
    {
		if (dp[x - 1][y - 1] != -1) 
        {
			return dp[x - 1][y - 1];
		}

		if (x == 1 && y == 1) 
        {
			dp[x - 1][y - 1] = cost[0][0];
			return dp[x - 1][y - 1];
		}

		int minCost = Integer.MAX_VALUE;

		if ((x - 1) > 0)
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x - 1, y, dp));
		}

		if ((y - 1) > 0) 
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x, y - 1, dp));
		}

		if ((x - 1) > 0 && (y - 1) > 0) 
        {
			minCost = Math.min(minCost, cost[x - 1][y - 1] + minCostPathHelper(cost, n, m, x - 1, y - 1, dp));
		}

		dp[x - 1][y - 1] = minCost;

		return dp[x - 1][y - 1];
	}

	public static int minCostPath(int[][] cost, int x, int y) 
    {
		int n = cost.length;
		if (n == 0) 
        {
			return Integer.MAX_VALUE;
		}

		int m = cost[0].length;

		int[][] dp = new int[x][y];

		for (int i = 0; i < x; i++) 
        {
			// Initializing all elements of newly formed row with -1
			Arrays.fill(dp[i], -1);

		}

		return minCostPathHelper(cost, n, m, x, y, dp);
	}
}



//Iterative DP approach


public class Solution 
{
	public static int minCostPath(int[][] input, int x, int y) 
    {
		//Your code goes here
		
		 int[][] dp=new int[x+1][y+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
		//Bottom to top approach
        for(int i=x-1;i>=0;i--){
            for(int j=y-1;j>=0;j--){
                if(i==x-1 && j==y-1){
                    dp[i][j]=input[i][j];
                    continue;
                }
                dp[i][j]=input[i][j]+(Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])));
                    
            
        }
                                      }
        return dp[0][0];
	}

}
