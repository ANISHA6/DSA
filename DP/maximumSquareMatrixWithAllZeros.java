public class Solution {
	

	public static int findMaxSquareWithAllZeros(int[][] input){
        //Base case
	        if(input.length==0){
            return 0;
        }
        int max=0;
       
        int n=input.length;
        //Filling 1st row 
        int[][] dp=new int[n][n];
        for(int r=0;r<input[0].length;r++){
            if(input[0][r]==0){
            dp[0][r]=1;
            max=1;}
    
        }
      for(int c=0;c<n;c++){
        if(input[c][0]==0){
            dp[c][0]=1;
                max=1;
            
            }
      }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<input[0].length;j++){
                if(input[i][j]==0){
                dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
            }else
                    dp[i][j]=0;
            }
        }
           
        return max;
  }
}
