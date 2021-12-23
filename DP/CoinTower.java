public static String findWinner(int n, int x, int y) {
		//Your code goes here
        
        boolean[] dp=new boolean[n+1];
        dp[1]=true;
        for(int i=2;i<=n;i++){
            if(i-1>=0 &&dp[i-1]==false)
              dp[i]=true;
            else if(i-x>=0 && dp[i-x]==false)
                dp[i]=true;
            else if(i-y>=0 && dp[i-y]==false)
                dp[i]=true;
            else
                dp[i]=false;
        }
        
  
//   Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, 
//   the player can remove either 1, X, or Y coins from the tower. 
//     The person to make the last move wins the game. Can you find out who wins the game?
    
//     Sample Input 1 :4 2 3
// Sample Output 1 :Whis
// Sample Input 2 :10 2 4
// Sample Output 2 :Beerus
