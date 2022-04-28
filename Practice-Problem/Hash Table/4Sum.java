//Method 1, sorting+ 2 pointer+ binary serach

/*
	Time Complexity: O(N^3)
	Space complexity: O(1)

	Where 'N' is the number of element present in the given array.
*/

import java.util.Arrays;

public class Solution {
    public static String fourSum(int[] arr, int target, int n) {

        // First sort the array.
        Arrays.sort(arr);

        /* 
            Fix first two elements and find other 
            two elements using two pointer technique.
        */
        for (int i = 0; i < n - 3; ++i) {
            for (int j = i + 1; j < n - 2; ++j) {
                // First index of remaining elements.
                int left = j + 1;
                // Last index of remaining elements.
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    // If we found the target sum then we return Yes.
                    if (sum == target) {
                        return "Yes";
                    } else if (sum < target) {

                        /*
                            As we already sort the array this implies arr[left] < = arr[right]
                            And arr[right] is already having a greater value 
                            so we can not increase arr[right] further. In this case, we move 
                            forward through the left pointerb because 
                            arr[left+1] >= arr[left] to match up with the required sum.
                         */

                        ++left;
                    } else {

                        /*
                            If the sum is greater than target that means we need to 
                            decrease our current sum so in this case, we move 
                            backward through the right pointer because 
                            arr[right-1] <= arr[right] to match up with the required sum.
                         */

                        --right;
                    }
                }

            }
        }
        // If we can not found the target sum then we return No.
        return "No";
    }
}

//Method 2, usind HashMap

/*
    Time Complexity: O(N^2)
    Space complexity: O(N^2)

    Where 'N' is the number of element present in the given array.
*/

import java.util.HashMap;

public class Solution {
    public static String fourSum(int[] arr, int target, int n) {

        HashMap < Integer, Pair > map = new HashMap < > ();
        /* 
            Preparing a HashMap which will store sum of two 
            elements of array arr[] as key and their 
            indexes as value.
        */
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                map.put(arr[i] + arr[j], new Pair(i, j));
            }
        }
        
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int requiredSum = target - (arr[i] + arr[j]);
                /* 
                    If HashMap contains required sum then we must
                    ensure that both pairs does not contain 
                    common indexes.
                */
                if (map.containsKey(requiredSum) && !commonIdx(map.get(requiredSum), new Pair(i, j))) {
                    return "Yes";
                }
            }
        }
        // If we can not found the target sum then we return No.
        return "No";

    }

    private static boolean commonIdx(Pair p1, Pair p2) {
        return p1.idx1 == p2.idx1 || p1.idx1 == p2.idx2 || p1.idx2 == p2.idx1 || p1.idx2 == p2.idx2;
    }

    // Custom Pair class to store pair of indexes.
    static class Pair {
        int idx1;
        int idx2;

        Pair(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }
    }
}

