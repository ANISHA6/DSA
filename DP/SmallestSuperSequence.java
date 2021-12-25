public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {

       
        int n1=str1.length();
        int n2=str2.length();
        int[][] dp=new int[n1+1][n2+1];
        
        int k=n2;
    for(int i=0;i<=n2;i++){ //filling last row
        dp[n1][i]=k;
        k--;
    }
        k=n1;
        for(int j=0;j<=n1;j++){ // Filling last column
            dp[j][n2]=k--;
        }
        
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=1+Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
        
        
        
}
}
