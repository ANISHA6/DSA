public class Solution {

	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        if(houses.length==0){
            return 0;
        }
        
        if(houses.length==1){
            return houses[0];
        }
        
        if(houses.length==2){
            return Math.max(houses[0],houses[1]);
        }
        int[] dp=new int[houses.length];
        dp[0]=houses[0];
     
        dp[1]=Math.max(dp[0],houses[1]);
        
        for(int i=2;i<houses.length;i++){
            dp[i]=Math.max(houses[i]+dp[i-2], dp[i-1]);
        }
        return dp[houses.length-1];
	}

}

// A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
  
//   Sample Input 2 :
// 6,no of houses
//   10 2 30 20 3 50
// Sample Output 2 :90
// Explanation of Sample Output 2 :
// Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.



Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.
