/*
	Time Complexity: O(N ^ 2)
	Space Complexity: O(1)

	Where 'N' is the size of array/list.
*/
//Method 1
public class Solution{
	public static int findMajority(int[] arr, int n) {
		// Iterating each element in the array/list and check if it is a majority element.
		for (int i = 0; i < n; i++) {
			// Variable to store the frequency of the current element at index 'i'.
			int maxCount = 0;

			// Iterating the array/list to count the frequency of the current element at index 'i'.
			for (int j = 0; j < n; j++) {
				// Increment the count of variable if an occurrence of the current element is observed.
				if (arr[j] == arr[i]) {
					maxCount++;
				}
			}

			// If count of any element exceeds 'n' / 2, then it is the majority element.
			if (maxCount > n / 2) {
				return arr[i];
			}
		}

		// If no majority element found, return -1.
		return -1;
	}
}
//Method 2
/*
	Time Complexity: O(N)
	Space Complexity: O(N)

	Where 'N' is the size of array/list.
*/
import java.util.*;
public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Write your code here.
		
		HashMap<Integer, Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			int c=map.get(arr[i]);
			if(c>Math.floor(n/2)){
				return arr[i];
			}
		}
		
// 		for(Map.Entry<Integer, Integer> m:map.entrySet()){
// 			if(m.getValue()> Math.floor(n/2)){
// 				return m.getKey();
// 			}
// 		}
		return -1;
		
		
	}
}

//Method 3

/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where 'N' is the size of array/list.
*/

public class Solution {

	public static int findMajority(int[] arr, int n) {
		// Variable to store the majority element in the array, it it is present.
		int majorityElement = -1;
		int count = 0;

		// Iterating the array to know if there is a possible majority element present.
		for (int i = 0; i < n; i++) {
			// If count becomes 0, set current element as a possible candidate for majority element, reset count to 1.
			if (count == 0) {
				majorityElement = arr[i];
				count = 1;
				continue;
			}

			// Increment the count if the current element of the array is equal to the current majority element, else decrement it.
			if (arr[i] == majorityElement) {
				count++;
			} else {
				count--;
			}
		}

		count = 0;

		// Checking if majority element occurs more than 'n' / 2 times.
		for (int i = 0; i < n; i++) {
			if (arr[i] == majorityElement) {
				count++;
			}
		}

		// If the count of the majority element is greater than 'n' / 2, then return it.
		if (count > n / 2) {
			return majorityElement;
		}

		// If no majority element found, return -1.
		return -1;
	}

}
