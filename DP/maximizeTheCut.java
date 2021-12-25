public class Solution {

    public static int maxSegments(int L, int a, int b, int c) {
        //Write your code here
        
        int[] dp=new int[L+1];
        for(int i=1;i<=L;i++){
            dp[i]=-1;
        }
        dp[0]=0;
        
        for(int i=0;i<=L;i++){
            
            if(dp[i]==-1){
                continue;
            }
            if(i+a<=L){
            dp[i+a]=Math.max(dp[i+a],dp[i]+1);}
        if(i+b<=L){
            dp[i+b]=Math.max(dp[i+b],dp[i]+1);}
        
        if(i+c<=L){
            dp[i+c]=Math.max(dp[i+c],dp[i]+1);}
            
        }
        return dp[L];
    }
        
}
