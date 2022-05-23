//Brute force

/*
    Time Complexity = O(N ^ 3)
    Space Complexity = O(N)
    
    Where N is the length of the string.
*/

public class Solution {

	private static boolean isPalindrome(String sub) {
		int n = sub.length();

		int i = 0, j = n - 1;

		while (i < j) {
			if (sub.charAt(i) != sub.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static String longestPalinSubstring(String str) {

		int n = str.length();

		// Start finding palindrome having maximum length.
		for (int len = n; len >= 1; len--) {
			for (int j = 0; j + len <= n; j++) {

				// Get the input starting from j and having length len.
				String input = str.substring(j, j + len);

				if (isPalindrome(input)) {
					return input;
				}
			}
		}

		return "";
	}
}



//using DP
/*
    Time Complexity = O(N ^ 2)
    Space Complexity = O(N ^ 2)
    
    Where N is the length of the string.
*/

public class Solution {

	public static String longestPalinSubstring(String str) {

		int n = str.length();

		if (n < 1) {
			return "";
		}

		/*
			dp[i][j] will be true if str[i..j] is palindrome.
			Else dp[i][j] will be false.
		*/
		boolean[][] dp = new boolean[n][n];

		int maxLength = 1;

		// Single letter is always palindromic.
		for (int i = 0; i < n; ++i) {
			dp[i][i] = true;
		}

		int start = 0;

		// Substring of length 2.
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dp[i][i + 1] = true;
				
				if (maxLength < 2) {
					start = i;
					maxLength = 2;
				}
			}
		}

		/*
			Check for lengths greater than 2.
			k is length of substring.
		*/
		for (int len = 3; len <= n; len++) {

			// Fix the starting index.
			for (int i = 0; i < n - len + 1; ++i) {

				// Ending index of length len.
				int j = i + len - 1;

				// Condition of str[i,j] to be palindromic.
				if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = true;

					// Update the starting index and the length.
					if (len > maxLength) {
						start = i;
						maxLength = len;
					}
				}

			}
		}

		return str.substring(start, start + maxLength);
	}

}


//Expanding around the centres a/c to odd and even length
/*
    Time Complexity = O(N ^ 2)
    Space Complexity = O(1)
    
    Where N is the length of the string.
*/

public class Solution {

	private static int expandAroundCenter(String str, int left, int right) {

		int start = left, end = right;
		int n = str.length();

		// Expand the center.
		while (start >= 0 && end < n && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}

		return end - start - 1;
	}

	public static String longestPalinSubstring(String str) {

		int n = str.length();

		if (n < 1) {
			return "";
		}

		int start = 0, end = 0;

		for (int i = 0; i < n; i++) {

			// Longest odd length palindrome with center points as i.
			int len1 = expandAroundCenter(str, i, i);

			// Longest even length palindrome with center points as i and i + 1.
			int len2 = expandAroundCenter(str, i, i + 1);

			int len = Math.max(len1, len2);

			// Update the start and end.
			if (len > end - start + 1) {
				start = i - (len - 1) / 2;
				end = i + (len) / 2;
			}

		}

		return str.substring(start, end + 1);
	}

}
