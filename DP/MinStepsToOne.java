// Using recursion
public class Solution {

	public static int countMinStepsToOne(int n) {
		//Your code goes here
        // TC:O(3^n), SC:O(n)
        if(n==1){
            return 0;
        }
        int ans1=countMinStepsToOne(n-1); // this will always work
        int ans2=Integer.MAX_VALUE;
        int ans3=Integer.MAX_VALUE;
        
        if(n%2==0){
            ans2=countMinStepsToOne(n/2);
        }
        if(n%3==0){
            ans3=countMinStepsToOne(n/3);

        }
        return Math.min(ans1, Math.min(ans2,ans3))+1;
        
        
	}

}
//Iterative DP
public static int countMinStepsToOne(int n) {
// 		//Your code goes here
       //TC:O(n), SC:O(n)
        
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
                
        for(int i=2;i<=n;i++){
            
           int ans1=dp[i-1];
            if(i%2==0){
                ans1=Math.min(ans1,dp[i/2]);
            }if(i%3==0){
                ans1=Math.min(ans1,dp[i/3]);
            }
            
            dp[i]=ans1+1;
            
        }
        return dp[n];
}


// DP + Recursion, error=Stack overflow
 public static int getmin(int n, int[] dp){
        
        if(n==1){
            return 0;
        }
        if(dp[n]!=-1)
            return dp[n];
       int res=getmin(n-1,dp);
    
        if(n%2==0)
            res=Math.min(res,getmin(n/2,dp));
        if(n%3==0){
            res=Math.min(res,getmin(n/3,dp));
        }
         //   res=getmin(n-1,dp);
        dp[n]=1+res;
        return dp[n];
    }
	public static int countMinStepsToOne(int n) {
// 		//Your code goes here
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        return getmin(n, dp);
  }

