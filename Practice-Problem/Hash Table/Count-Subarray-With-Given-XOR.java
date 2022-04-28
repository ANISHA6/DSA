//Method 1, brute force 

/*
    Time Complexity : O(N ^ 2)
    Space Complexity : O(1)
    
    Where 'N' denotes the number of elements in the given array.
*/

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {

		int ans = 0;

		int n = arr.size();

		// Traverse through each subarray
		for (int i = 0; i < n; i++) {
			// The variable currentXor stores the XOR of the current subarray
			int currentXor = 0;

			for (int j = i; j < n; j++) {
				currentXor = currentXor ^ arr.get(j).intValue();

				// Check if currentXor is equal to x
				if (currentXor == x) {
					ans++;
				}
			}
		}

		// Return the variable ans
		return ans;
	}
}

//Method 2, using hashmap


import java.util.*;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
		HashMap<Integer,Integer> feq=new HashMap<>();
		int count=0;
		int xor=0;
		
    //xr=prefix xor
    //xr=y^x
    //y=xr^x
    
		for(int i=0;i<arr.size();i++){
			xor^=arr.get(i);
			if(feq.get(xor^x)!=null){//y=xr^x,  xr=xor
				count+=feq.get(xor^x);//incrementing count with , frequency of y
			}
			
	      if(xor==x){// if current prefix xor is equal to x
				count++;
			}
			feq.put(xor, feq.getOrDefault(xor, 0)+1);// put every prefix xor with its count
		}
		return count;
	}
}
