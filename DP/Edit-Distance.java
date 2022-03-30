public class Solution {

	public static int editDistance(String s, String t) {
		//Your code goes here
         if(s.length()==0 && t.length()==0){
            return t.length();
        }
        
        if(s.length()==0 && t.length()!=0){
            return t.length();
        }
                if(t.length()==0 && s.length()!=0){
            return s.length();
        }
        
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for(int j=0;j<=m;j++){
            dp[j][0]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }}
        }
            return dp[m][n];
        
        
    }

}
