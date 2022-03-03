/*
    Time Complexity: O(N*logn(N))
    Space Complexity: O(1)

    Where N is the length of array.
*/

import java.util.Arrays;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Sort the given array in ascending order.
        Arrays.sort(arr);

        // To store length of longest consecutive sequence.
        int mx = 0;

        // To store the length of current consecutive Sequence.
        int count = 0;

        for (int i = 0; i < N; i++) {

            // Check if previous value is consecutive to the current value.
            if (i > 0 && (arr[i] == arr[i - 1] + 1)) {
                count++;

            }
            // Skip if the current value is equals to the previous value.
            else if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // Reseting count for next upcoming consecutive sequence.
            else {
                count = 1;
            }

            mx = Math.max(mx, count);
            
        }

        return mx;
    }
}


// Method--2
/*  
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where N is the length of the given array.
*/

import java.util.HashSet;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // To store length of longest consecutive sequence.
        int mx = 0;

        // To store the length of current consecutive Sequence.
//         int count = 0;, we can also find it without using count

        // To store all the unique elements of array.
        HashSet<Integer> set = new HashSet<>();

        for (Integer element : arr) {
            set.add(element);
        }

        for (Integer element : arr) {
            int previousConsecutiveElement = element - 1;

            if (!set.contains(previousConsecutiveElement)) {

                // Element is the first value of consecutive sequence.
                int j = element;
                
                while (set.contains(j)) {
                    // The next consecutive element by will be j + 1.
                    j++;
                }

                // Update maximum length of consecutive sequence.
                mx = Math.max(mx, j - element);
            }

        }

        return mx;
    }
}
