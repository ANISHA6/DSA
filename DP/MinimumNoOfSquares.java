public class Solution {
    
    //Recursive + Memoization
   public static int helper(int n,int[] dp){
     if(n==0){
            return 0;
        }
     int minAns=Integer.MAX_VALUE;
       for(int i=1;i*i<=n;i++){
           
           int currAns;
           if(dp[n-(i*i)]==-1){
               currAns=helper(n-(i*i),dp);
               dp[n-(i*i)]=currAns;
           }else
               currAns=dp[n-(i*i)];
           if(minAns>currAns)
               minAns=currAns;
       }
       return minAns+1;
        }
    public static int minCount(int n) {
		//Your code goes here
        
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return helper(n,dp);
	}
  
  // Iterative DP
   public static int minCount(int n) {
// 		//Your code goes here
     TC:O(n(square root n)), SC:O(n)
        
         //Itrative DP
        int[] minsquare=new int[n+1];
        minsquare[0]=0;
        minsquare[1]=1;
        for(int i=2;i<=n;i++){
            minsquare[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                minsquare[i]=Math.min(minsquare[i],minsquare[i-j*j]);
            }
            minsquare[i]=minsquare[i]+1;
        }
        return minsquare[n];
        
        
        
	}
