public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {

       //Bottom up approach
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



        // Top down approach
        //First fill base condition
        // filling 1st row
        for(int i=0;i<=n2;i++){
            dp[0][i]=i;
        }
        
        //filling 1st col
        for(int i=0;i<=n1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
        
        
        //method 3, 1st find LCS, then, n1+n2-x
        
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int x= dp[n1][n2];
        return n1+n2-x;
        
        
        
        
}
}
