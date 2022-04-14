/*
    Time Complexity: O(2^N)
    Space Complexity: O(N*2^N)

    where N is the size of given input array.
*/

import java.util.ArrayList;

public class Solution {

    static ArrayList<ArrayList<Integer>> FindAllSubsets(int n, ArrayList<Integer> arr) {

        // 2D ArrayList to store answer
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Temporary ArrayList to store current subset
        ArrayList<Integer> temp = new ArrayList<>();

        // Initial call to recursive function
        SubsetFinder(0, temp, ans, arr);

        // Returning the final answer
        return ans;

    }

    private static void SubsetFinder(int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans,
            ArrayList<Integer> arr) {

        // Base condition
        if (i == arr.size()) {
            // Adding non-empty current subset generated to answer
            if (temp.size() > 0) {
                ans.add(temp);
            }
            return;
        }

        // Generating subset which has ith array element in it
        ArrayList<Integer> temp1 = new ArrayList<>(temp);
        temp1.add(arr.get(i));
        SubsetFinder(i + 1, temp1, ans, arr);

        // Generating subset which doesn't has ith array element
        SubsetFinder(i + 1, temp, ans, arr);
    }

}
