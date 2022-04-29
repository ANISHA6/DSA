//Method 1, brute force

/*
    Time complexity: O(N * log(N))
    Space complexity: O(1)

    Where 'N' is the length of the strings.
*/

import java.util.Arrays;

public class Solution {
	public static boolean areAnagram(String str1, String str2) {
		// Get lengths of both strings.
		int n1 = str1.length();
		int n2 = str2.length();

		// If length of both strings is not same then they cannot be anagram.
		if (n1 != n2) {
			return false;
		}

		// Convert input string to char array.
		char tempArray1[] = str1.toCharArray();
		char tempArray2[] = str2.toCharArray();

		// Sort tempArray.
		Arrays.sort(tempArray1);
		Arrays.sort(tempArray2);

		// Compare sorted strings.
		for (int i = 0; i < n1; i++) {
			if (tempArray1[i] != tempArray2[i]) {
				return false;
			}
		}
		return true;
	}
}

//Method 2, Hashing

/*
    Time complexity: O(N)
    Space complexity: O(Number of different characters).

    Where 'N' is the length of the string.
*/

import java.util.ArrayList;

public class Solution {
	public static boolean areAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int NO_OF_CHARS = 256;

		// Create a count array and initialize all values as 0.
		int[] hash = new int[NO_OF_CHARS];
		for (int i = 0; i < NO_OF_CHARS; i++) {
			hash[i] = 0;
		}

		int i;
		/*
		   For each character in input strings,
		   increment count in the corresponding count array.
		*/
		for (i = 0; i < str1.length(); i++) {
			hash[str1.charAt(i)]++;
			hash[str2.charAt(i)]--;
		}

		// Check if all values in hash array are 0.
		for (i = 0; i < NO_OF_CHARS; i++) {
			if (hash[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
