//Method 1, brute force
/*
    Time Complexity: O(N^2)
    Space Complexity: O(1)

    Where 'N' denotes the number of elements of the array
*/

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Initialize result
		int maxLen = 0;
		int n = arr.size();

		// Pick a starting point
		for (int i = 0; i < n; i++) {

			// Initialize currSum for every starting point
			int currSum = 0;

			// Try all subarrays starting with 'i'
			for (int j = i; j < n; j++) {
				currSum += arr.get(j);

				// If currSum becomes 0,then update maxLen if required

				if (currSum == 0)
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		return maxLen;
	}
}

//Method 2, using hashMap
/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where 'N' denotes the number of elements of the array
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Map to store the previous sums
		HashMap<Integer, Integer> presum = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize the sum of elements
		int maxLen = 0; // Initialize result
		int n = arr.size();
		// Traverse through the given array
		for (int i = 0; i < n; i++) {
			// Add current element to sum
			sum += arr.get(i);

			if (arr.get(i) == 0 && maxLen == 0)
				maxLen = 1;
			if (sum == 0)
				maxLen = i + 1;

			// Look for this sum in Hash table
			if (presum.containsKey(sum)) {
				// If this sum is seen before, then update maxLen
				maxLen = Math.max(maxLen, i - presum.get(sum));
			} else {
				// Else insert this sum with index in hash table
				presum.put(sum, i);
			}
		}

		return maxLen;
	}
}
