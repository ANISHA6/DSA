//Method 1
/*
    Time Complexity - O(N ^ 3)
    Space complexity - O(N ^ 2)
    where N is the size of the input String.
*/

import java.util.ArrayList;

public class Solution {
    public static int palindromicSubstrings (String str) {
        int count = 0;

        ArrayList<String> listOfSubstrings = new ArrayList<>();
        
        // Storing all the substrings.
        for (int start = 0; start < str.length(); start++) {
            for (int end = start + 1; end <= str.length(); end++) {

                String substring = str.substring(start, end);
                listOfSubstrings.add(substring);
            }
        }

        // Iterating over all the substrings and incrementing the
        // count variable if a palindromic substring is found.  
        for (String substring : listOfSubstrings) {
            if (isPalindrome(substring)) {
                count++;
            }
        }

        return count;
    }

    // Check whether the string is palindrome or not.
    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Iterating over the string to check if it's palindrome or not.
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

//Method 2

/*
    Time Complexity - O(N ^ 2)
    Space complexity - O(1)

    where N is the size of the input String.
*/

public class Solution {
    public static int palindromicSubstrings(String str) {
        int ans = 0;

        // Finding all the odd length palindromes with center at 'i'.
        for (int i = 0; i < str.length(); i++) {
            
            int left = i;
            int right = i;

            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }

        // Finding all the even length palindromes with center between 'i' and 'i + 1'.
        for (int i = 0; i < str.length() - 1; i++) {

            int left = i;
            int right = i + 1;
            
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }
}


