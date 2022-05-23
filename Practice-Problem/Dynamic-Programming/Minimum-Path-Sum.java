//Recursion
/*
    Time Complexity: O(2 ^ (N + M))
    Space Complexity: O(N + M)

    Where 'N' is the number of rows and 'M' is the number of columns in grid.
*/

import java.util.Arrays;

public class Solution {
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Calling the helper function to calculate the minimum sum path.
        int minSum = minSumHelper(grid, 0, 0, n, m);

        return minSum;
    }

    public static int minSumHelper(int[][] grid, int i, int j, int n, int m) {
        // If indexes are out of range then return a very large value.
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        // If it is bottom right end of the grid then return its value.
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        // Check in both the directions.
        int right = minSumHelper(grid, i, j + 1, n, m);
        int down = minSumHelper(grid, i + 1, j, n, m);

        // Calculate and return the current sum.
        int curSum = grid[i][j] + Math.min(right, down);
        return curSum;
    }
}

//Memoization
/*
    Time Complexity: O(N * M)
    Space Complexity: O(N * M)

    Where 'N' is the number of rows and 'M' is the number of columns in grid.
*/

import java.util.Arrays;

public class Solution {

    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Declaring a table to keep the value of already calculated subproblems.
        int[][] lookUp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(lookUp[i], -1);
        }

        // Calling the helper function to calculate the minimum sum path.
        int minSum = minSumHelper(grid, lookUp, 0, 0, n, m);
        return minSum;
    }

    public static int minSumHelper(int[][] grid, int[][] lookUp, int i, int j, int n, int m) {
        // If indexes are out of range then return a very large value.
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        // If it is bottom right end of the grid then return its value.
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        // If the ans for subproblem already exist.
        if (lookUp[i][j] != -1) {
            return lookUp[i][j];
        }

        // Check in both the directions.
        int right = minSumHelper(grid, lookUp, i, j + 1, n, m);
        int down = minSumHelper(grid, lookUp, i + 1, j, n, m);

        // Storing the ans for furthur use.
        lookUp[i][j] = grid[i][j] + Math.min(right, down);
        return lookUp[i][j];
    }

}
//itrative approach with space optimaization

//  Time Complexity: O(N * M)
//     Space Complexity: O(N)

import java.util.*;

public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
// 		int ans=0;
		int r=grid.length;
		int c=grid[0].length;
		
		int[] pre=new int[r];
		
		
		for(int i=0;i<r;i++){
		int[] temp=new int[c];
			
			for(int j=0;j<c;j++){
				if(i==0 && j==0){
					temp[j]=grid[i][j];
				}else{
					int up=grid[i][j];
					if(i>0) up+=pre[j];
					else up+=(int)Math.pow(10,9);
					
					int left=grid[i][j];
					if(j>0) left+=temp[j-1];
					else left+=(int)Math.pow(10,9);
					
					temp[j]=Math.min(up, left);
				}
			}
			pre=temp;
		}
		return pre[c-1];
		
    }
}
