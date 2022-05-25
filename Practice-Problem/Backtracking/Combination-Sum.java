/*
    Time complexity: O(2 ^ N)
    Space complexity: O(N)

    Where 'N' is size of the given array 'Arr'.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	private static void subsetSum(ArrayList<Integer> array, int startingIndex, int target, ArrayList<Integer> currCombination, ArrayList<ArrayList<Integer>> output) 
	{
		// The current combination has required sum.
		if (target == 0) 
		{
			output.add(new ArrayList<>(currCombination));
			return;
		}

		for (int i = startingIndex; i < array.size(); i++) 
		{

			int curr = array.get(i);

			if (curr > target) 
			{
				continue;
			}

			// Skip multiple occurrences.
			if (i > startingIndex && array.get(i) == array.get(i - 1)) 
			{
				continue;
			}

			// Append the element in current combination.
			currCombination.add(curr);

			subsetSum(array, i + 1, target - curr, currCombination, output);

			// Remove the element from current combination.
			currCombination.remove(currCombination.size() - 1);
		}
	}

	public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) 
	{

		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		
		ArrayList<Integer> currCombination = new ArrayList<>();

		// Sort the array
		Collections.sort(arr);

		subsetSum(arr, 0, target, currCombination, output);
		return output;
	}
}
