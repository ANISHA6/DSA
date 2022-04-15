//Method 1
/*	
	Time complexity: O(Log2(N))
	Space complexity: O(Log2(N))

	where 'N' is the given number.
*/

public class Solution {

	// Function to check if n is power of 2.
	public static boolean isPowerOfTwo(int n) {

		// Base case: '1' is the only odd number which is a power of 2(2^0).
		if (n == 1) {
			return true;
		}

		// All other odd numbers are not powers of 2.
		else if (n % 2 != 0 || n == 0) {
			return false;
		}

		// Recursive function call.
		return isPowerOfTwo(n / 2);
	}
}
//Method 2

/*
	Time complexity: O(Log2(N))
	Space complexity: O(1)

	where 'N' is the given number.
*/

public class Solution {

	// Function to check if n is power of 2.
	public static boolean isPowerOfTwo(int n) {

		if (n == 0) {
			return false;
		}

		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}
}


//Method 3

/*
	Time complexity: O(1)
	Space complexity: O(1)

	where 'N' is the given number.
*/

public class Solution {
	// Method to check if n is power of 2.
	public static boolean isPowerOfTwo(int n) {
		// First n in the below expression is for the case when n is 0.
		return n != 0 && ((n & (n - 1)) == 0);
	}
}
