public static int countWaysToMakeChange(int denominations[], int value){
        // Write your code here
//this problem is same as subset sum to k
        //Method 1
        int n=denominations.length;
        
        int[] dp=new int[value+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=denominations[i];j<=value;j++){
                dp[j]+=dp[j-denominations[i]];
            }
        }
        return dp[value];
	}

//method 2, same as to find subset sum to k
public static int countWaysToMakeChange(int denominations[], int value){
        // Write your code here
  TC=SC:O(N^2)
      int n=denominations.length;
      int sum = value;
     
        long t[][] = new long[n+1][sum+1];
        
        for(int i=0; i<=n; i++)
            t[i][0] = 1;
        for(int i=1; i<=sum; i++)
            t[0][i] = 0;
            
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(S[i-1] <= j)
                    t[i][j] = t[i][j-S[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
             }
        }
        
        return t[n][sum];
    } 
