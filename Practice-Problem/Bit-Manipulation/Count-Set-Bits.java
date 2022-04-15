//Method 1
/*
    Time Complexity: O(N * log(N))
    Space Complexity: O(1)

    Where 'N' is the given number
*/

import java.util.*;
import java.lang.*;

public class Solution 
{

	public static int countSetBitsHelper(int n) 
	{
		int count = 0;

		while (n > 0) 
		{
            
			// Check if last bit is set
			if (n % 2 != 0) 
			{
				count += 1;
			}

			// Divide by 2
			n = n / 2;
		}

		return count;
	}

	public static int countSetBits(int n) 
	{
		int mod = (int)1e9 + 7;

		int count = 0;

		for (int i = 1; i <= n; i++) 
		{

			// For each number find it's contribution to the count
			count = (count + countSetBitsHelper(i)) % mod;
		}

		return count;

	}
}

//Method 2


public class Solution 
{
	public static int set(int i){
		int count=0;
		while(i>0){
			i &= (i-1);//It will make last set bit to unset
			count++;
			}
		return count;
	}
	
    public static int countSetBits(int n) 
    {
        //    Write your code here.
		int mod = (int)1e9 + 7;
		int count=0;
		for(int i=1;i<=n;i++){
		count= (count + set(i))% mod ;
		}
		return count % mod;
    }
}
