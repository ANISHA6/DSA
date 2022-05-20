public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		
		int[][] dp=new int[n+1][n+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(i<=j){
					dp[i][j]=Math.max(price[i-1]+dp[i][j-i], dp[i-1][j]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][n];
	}
}
