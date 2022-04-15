//Method 1, brute force approach
/*
    Time Complexity: O(log N)
    Space complexity: O(1)

    Where N is the given number.
*/

public class Solution {
    public static int findMSB(int n) {
            
        int ans = 1;

        while(n != 1){
            n = n / 2;
            ans = ans * 2;
        }

        return ans;
    }
}

//Method 2, Using log and pow functions

/*
    Time Complexity: O(log N)
    Space Complexity: O(1)

    Where N is the given number.
*/

import java.lang.Math;

public class Solution {
    public static int findMSB(int n) {
            int x = (int) (Math.log(n) / Math.log(2));
    
            return (int)Math.pow(2, x);
    }
}

//Method 3, Using left shift
TC=SC:O(1)

public class Solution {
    public static int findMSB(int n) {
        // Write your code here.
		for(int i=30;i>=0;i--){
			if((1<<i)<=n)
				return 1<<i;
		}
		return n;
    }
}

//Method 4, using right shift and bitwise OR

/*
    Time Complexity: O(1)
    Space complexity: O(1)
*/

public class Solution {
    public static int findMSB(int n) {
        
        n = n | n >> 1;
        n = n | n >> 2;
        n = n | n >> 4;
        n = n | n >> 8;
        n = n | n >> 16;

        n = n + 1;

        return (n >> 1);

    }
}
