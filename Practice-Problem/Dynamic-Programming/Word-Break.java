//Method 1, Brute force approach or Recursion

/*
    Time Complexity  : O(2 ^ N)
    Space Complexity : O(N)

    Where N is the length of target string.
*/

import java.util.HashSet;

public class Solution {

    // Declare a hash map.
    static HashSet < String > hashMap = new HashSet < > ();

    public static boolean wordBreakHelper(String s) {

        // Len denotes size of current string.
        int len = s.length();

        // Base case.
        if (len == 0) {
            return true;
        }

        // Run a loop from 1 to length of target string.
        for (int i = 1; i <= len; i++) {
            /*
              If substring from 0 to i exist in hash map 
              and remaining string recurs true then return true.
            */
            if (hashMap.contains(s.substring(0, i)) && wordBreakHelper(s.substring(i, len))) {
                return true;
            }
        }

        // If no solution exist then return false.
        return false;
    }

    public static boolean wordBreak(String[] arr, int n, String target) {
        // Clear hash map for current test case.
        hashMap.clear();

        // Insert all strings of a into hashmap.
        for (String s: arr) {
            hashMap.add(s);
        }

        // Call wordBreakHelper to return answer.
        return wordBreakHelper(target);
    }
}

//Method 2, Memoization
//Tc:(N^3)

import java.util.*;
public class Solution {
	//Memoization method
	
public static boolean wb(String s, Set<String> dict, int pos, Boolean[] memo){
    if(pos == s.length()) return true;
    if(memo[pos] != null) return memo[pos];

    StringBuilder sb = new StringBuilder(s);

    for(int i=pos+1; i<=s.length(); i++){
        String str = sb.substring(pos, i);

        if(dict.contains(str) && wb(s, dict, i, memo)){
            memo[pos] = true;
            return true;
        }
    }
   
    memo[pos] = false;//if bot present in set or dict
    return false;
}
    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here. 
		if(target.length()==0)
			return true;
		//putting all the arr elements inside the hashset
		Set<String> set=new HashSet<>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
    return wb(target, set, 0, new Boolean[target.length()]);
		
    }
}

//Method 3, top down approach
/*
    Time Complexity  : O(N ^ 2)
    Space Complexity : O(N)

    Where N is the length of target string.
*/

import java.util.HashSet;

public class Solution {

    // Declare a hash map.
    static HashSet < String > hashMap = new HashSet < > ();

    public static boolean wordBreakHelper(String s, int start, int[] dp) {
        // Base case.
        if (start == s.length()) {
            dp[start] = 1;
            return true;
        }

        // If result is already calculated then return it.
        if (dp[start] != -1) {

            return dp[start] != 0;
        }

        // Run a loop from 1 to length of target string.
        for (int i = start + 1; i <= s.length(); i++) {
            /*
              If substring from 0 to i exist in hash 
              map And remaining string recurs true.
            */
            if (hashMap.contains(s.substring(start, i))) {
                if (wordBreakHelper(s, i, dp)) {
                    dp[start] = 1;
                    return true;
                }
            }
        }

        // If no solution exist then return false.
        dp[start] = 0;
        return false;
    }

    public static boolean wordBreak(String[] arr, int n, String target) {
        // Clear hash map for current test case.
        hashMap.clear();

        // Insert all strings of a into hashmap.
        for (String s: arr) {
            hashMap.add(s);
        }

        // Declare dp array and initialize all values with -1.
        int[] dp = new int[target.length() + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        // Call wordBreakHelper to return answer.
        return wordBreakHelper(target, 0, dp);
    }
}

//Method 4, Bottom up approach

/*
    Time Complexity  : O(N ^ 2)
    Space Complexity : O(N)

    Where N is the length of target string.
*/

import java.util.HashSet;

public class Solution {
    public static boolean wordBreak(String[] arr, int n, String target) {
        // Declare a hash map.
        HashSet < String > hashMap = new HashSet < > ();

        // Insert all strings of a into hashmap.
        for (String s: arr) {
            hashMap.add(s);
        }

        // Declare dp array and initialize all values with false.
        Boolean[] dp = new Boolean[target.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        // Base case.
        dp[0] = true;

        // Run a loop from 1 to length of target string.
        for (int i = 1; i <= target.length(); ++i) {

            // Run a loop from i-1 to 0.
            for (int j = i - 1; j >= 0; --j) {

                // check only if a valid sequence of words (or a word) ends at j.
                if (dp[j]) {

                    // Check if remaining string exist in hashmap.
                    if (hashMap.contains(target.substring(j, i))) {

                        // Ending at i is a valid word So make dp[i] as true.
                        dp[i] = true;

                        // Break loop here because we have found a valid sequence ending here.
                        break;
                    }
                }
            }
        }

        // Return dp[length of target].
        return dp[target.length()];
    }
}

//Method 5, BFS approach

/*
    Time Complexity  : O(N ^ 2)
    Space Complexity : O(N)

    Where N is the length of target string.
*/

import java.util.*;

public class Solution {
    public static boolean wordBreak(String[] arr, int n, String target) {
        // Declare a hash map.
        HashSet < String > hashMap = new HashSet < > ();

        // Insert all strings of a into hashmap.
        for (String s: arr) {
            hashMap.add(s);
        }

        // Declare an empty queue.
        Queue < Integer > q = new LinkedList < > ();

        // Declare an empty hash map to keep track of visited nodes.
        HashSet < Integer > visited = new HashSet < > ();

        // Push 0 to queue.
        q.add(0);

        // Run a loop until q is not empty.
        while (q.size() > 0) {
            // Pop front element of queue.
            int frontElement = q.peek();
            q.remove();

            // Check if front element is already visited or not.
            if (!visited.contains(frontElement)) {
                // Mark front element as visited.
                visited.add(frontElement);

                // Run a loop from front element to size of target string.
                for (int j = frontElement; j < target.length(); j++) {
                    /*
                        If substring starting from j does 
                        not exist in hash map then push it to queue.
                    */
                    if (hashMap.contains(target.substring(frontElement, j + 1))) {
                        q.add(j + 1);

                        /*
                            If we have reached at the end of 
                            target String then return true.
                        */
                        if (j + 1 == target.length())
                            return true;
                    }
                }
            }
        }

        return false;
    }
}
