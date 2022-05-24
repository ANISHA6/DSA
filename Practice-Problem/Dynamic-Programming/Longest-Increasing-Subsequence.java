//Recursion, ERROr->TLE


public class Solution {
    public static int helper(int curr, int pre, int[] arr, int n ){
        if(curr==n){
            return 0;
        }
        int l=helper(curr+1, pre, arr, n);
        if(pre==-1 || arr[curr]>arr[pre]){
            l=Math.max(l,1+helper(curr+1, curr, arr, n));
        }
        return l;
    }

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        return helper(0, -1, arr, arr.length);
	}

}
//Memoization, giving TLE for some test cases

public class Solution {
    public static int helper(int curr, int pre, int[] arr, int n, int[][] dp ){
        if(curr==n){
            return 0;
        }
        if(dp[curr][pre+1]!=-1){
            return dp[curr][pre+1];
        }
        int l=helper(curr+1, pre, arr, n, dp);
        if(pre==-1 || arr[curr]>arr[pre]){
            l=Math.max(l,1+helper(curr+1, curr, arr, n, dp));
        }
        
        return dp[curr][pre+1]= l;
    }

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0, -1, arr, arr.length, dp);
	}

}
//Iterative, TLE
/*
    Time Complexity : O(N ^ 2)
    Space Complexity : O(N)

    Where N is the size of the array
*/

public class Solution 
{
	public static int longestIncreasingSubsequence(int arr[]) 
	{
		int n = arr.length;

		// dp[i] represents i+1'th length LIS ending at minimum integer dp[i]
		int dp[] = new int[n];

		// Base case
		dp[0] = 1;
		int ans = 0;

		for (int i = 1; i < n; i++) 
		{
			int maxVal = 0;

			for (int j = 0; j < i; j++) 
			{
				if (arr[i] > arr[j]) 
				{
					maxVal = Math.max(maxVal, dp[j]);
				}
			}

			dp[i] = maxVal + 1;
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

}

//Binary search + DP

/*
    Time Complexity : O(N * log(N))
    Space Complexity : O(N)

    Where N is the size of the array
*/

public class Solution 
{
	private static int lowerBound(int[] a, int low, int high, int element) 
	{
		while (low < high) 
		{
			int middle = low + (high - low) / 2;
			if (element > a[middle]) 
			{
				low = middle + 1;
			} else 
			{
				high = middle;
			}
		}

		return low;
	}
	public static int longestIncreasingSubsequence(int arr[]) 
	{
		int n = arr.length;

		// dp[i] represents i+1'th length LIS ending at minimum integer dp[i]
		int dp[] = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) 
		{
			/*
			    Since dp array stores elements in the sorted order therefore
			    we can use binary search to find the correct position for
			    arr[i] to be placed.
			    And elements are present in the dp array from 0 to ans-1 position
			    So we will be doing the binary search in this range.
			*/
			int position = lowerBound(dp, 0, ans, arr[i]);
			dp[position] = arr[i];

			if (position == ans) 
			{
				ans++;
			}
		}

		return ans;
	}

}

