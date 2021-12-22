
public static long staircase(int n) {
		//Your code goes here
        if(n==0||n==1||n==2){
            return n;
        }
        
        long[] dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
}

// A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. 
//   Implement a method to count and return all possible ways in which the child can run-up to the stairs.
