//Recursive approach
/*
    Time Complexity  : O(2 ^ (M + N)) 
    Space Complexity : O(max(M,N))
    
    Where 'M' is the number of rows and 'N' is the number of columns of the matrix.   
*/
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Base condition.
		if (m == 1 || n == 1) {
			return 1;
		}

		// Recursive call.
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

}

//Memoization
/*
    Time Complexity  : O(M * N) 
    Space Complexity : O(M * N)
    
    Where 'M' is the number of rows and 'N' is the number of columns of the matrix.   
*/

import java.util.Arrays;

public class Solution {
	static int uniquePathsHelper(int m, int n, int[][] lookupTable) {
		// Base condition
		if (m == 1 || n == 1) { 
			return 1;
		}

		// Check for solved subproblems.
		if (lookupTable[m][n] != -1) { 
			return lookupTable[m][n];
		}
		
		// Recursive call.
		int temp = uniquePathsHelper(m - 1, n, lookupTable) + uniquePathsHelper(m, n - 1, lookupTable); 
		lookupTable[m][n] = temp;
		return temp;
	}

	public static int uniquePaths(int m, int n) {
		// Lookup table.
		int[][] lookupTable = new int[m + 1][n + 1]; 
		for (int[] row : lookupTable) {
			Arrays.fill(row, -1);
		}

		// Calling helper function.
		return uniquePathsHelper(m, n, lookupTable); 
	}
}

//Iterative approach
/*
    Time Complexity  : O(M * N) 
    Space Complexity : O(M * N)
    
    Where 'M' is the number of rows and 'N' is the number of columns of the matrix.  
*/

public class Solution {
	public static int uniquePaths(int m, int n) {
		// Reference table to store subproblems.
		int[][] dp = new int[m][n];

		// Paths to reach a cell in column 1.
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		// Paths to reach a cell in row 1.
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		// Bottom up approach.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		// Returning answer.
		return dp[m - 1][n - 1];
	}
}

//Another way to write above code
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp=new int [m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0)
					dp[i][j]=1;
				else{
					int up=0;
					int left=0;
					if(i>0){
						up=dp[i-1][j];
					}
					if(j>0)
						left=dp[i][j-1];
					dp[i][j]=up+left;
				}
			}
		}
		return dp[m-1][n-1];
		
	}
}

// DP space optimized

/*
    Time Complexity  : O(M * N) 
    Space Complexity : O(N)
    
    Where 'M' is the number of rows and 'N' is the number of columns of the matrix.    
*/

public class Solution {
	public static int uniquePaths(int m, int n) {
		// Reference array to store subproblems.
		int[] dp = new int[n];
		dp[0] = 1;

		// Bottom up approach.
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		
		// Returning answer.
		return dp[n - 1];
	}
}
