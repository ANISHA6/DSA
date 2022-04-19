/*
    Time Complexity: O(N^2)
    Space Complexity: O(1)

    Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {

        // Variable to store the maximum profit.
        int maxProfit = 0;
        int n = prices.size();

        // Iterating over the array for the buying price.
        for (int i = 0; i < n - 1; i++) {

            /*
                Variables to store current buying price and
                maximum profit for if we buy stock at this minute.
            */
            int buy = prices.get(i), curMaxProfit = 0;

            /*
                Iterating over the next minutes for selling price,
                and storing the maximum profit we can get in curMaxProfit.
            */
            for (int j = i + 1; j < n; j++) {
                curMaxProfit = Math.max(curMaxProfit, (prices.get(j) - buy));
            }

            /*
                Taking the maximum of all the curMaxProfit and
                storing it in the maxProfit variable.
            */
            maxProfit = Math.max(maxProfit, curMaxProfit);
        }

        return maxProfit;
    }
}

//Method 2
/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices){
        
        // Variables to store the buying price and maximum profit
        int buy = prices.get(0),maxProfit = 0;
        int n = prices.size();

        // Iterating over the array
        for(int i = 1; i < n; i++){

            /*
                If current price is less than buying price
                we will update buying price as the current price.
            */
            if(prices.get(i) < buy){
                buy = prices.get(i);
            }
            
            /*
                Else if selling at this price is more profitable,
                then we will update out maximum profit.
            */
            else if( (prices.get(i) - buy) > maxProfit){
                maxProfit = prices.get(i) - buy;
            }
        }
        return maxProfit;
    }
}
