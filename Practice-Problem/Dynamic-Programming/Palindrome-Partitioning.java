import java.util.*;

//Error->TLE, for some test cases
public class Solution {
	
	public static void helper(String s, int index, List<List<String>> res, List<String> path){
		if(index==s.length()){
			res.add(new ArrayList<>(path));
			return ;
		}
		for(int i=index;i<s.length();i++){
			if(isPalindrome(s, index, i)){
				path.add(s.substring(index, i+1));
				helper(s,i+1, res, path);
				path.remove(path.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String str, int s, int e){
		while(s<e){
			if(str.charAt(s)!=str.charAt(e)){
				return false;
			}
		}
		return true;
	}
    public static List<List<String>> partition(String s) {
        // Write your code here.
		List<List<String>> res=new ArrayList<>();
		List<String> path=new ArrayList<>();
		
		helper(s, 0, res, path);
		return res;
		
}
}

//We are iterating each time to check whether a given substring is palindrome or not and there we are iterating the same substring of string again and again. 
// So there are overlapping subproblems.
//so to avoid Time Limit Exceeded error ,
//we use dynamic programming. To overcome the overlapping subproblems we can initially create the DP table which stores if substring[i….j] is palindrome or not. 
// We maintain a boolean dp[N][N] that is filled in a bottom-up manner. The value of dp[i][j] is true if the substring is a palindrome, otherwise false.

/*
    Time Complexity: O(N * 2 ^ N)
    Space Complexity: O(N ^ 2)

    Where 'N' is the length of string.
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<List<String>> partition(String s) {

        // It store all the possible palindromic partitions.
        List<List<String>> answer = new ArrayList<>();

        // Create a boolean dp for checking substing[i..j] is palindrome or not.
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        // Recursive function to generate all the possible palindromic partitions.
        partitionHelper(s, 0, answer, new ArrayList<>(), dp);

        return answer;
    }

    private static void partitionHelper(String s, int start, List<List<String>> answer, List<String> currentList,
            boolean[][] dp) {

        // If start reach the end of String.
        if (start >= s.length()) {

            // Add the current generated Palindromic Partition to answer List.
            answer.add(new ArrayList<>(currentList));
            return;
        }

        for (int k = start; k < s.length(); k++) {

            // Check if substring S[start...k] is Palindrome or not.
            if (dp[start][k]) {

                // Add the substring S[start...k].
                currentList.add(s.substring(start, k + 1));

                // Recurence for rest of the string to get all the palindromic partitions.
                partitionHelper(s, k + 1, answer, currentList, dp);

                // Remove the substring S[start...k] from current partition.
                currentList.remove(currentList.size() - 1);
            }
        }

    }

}
