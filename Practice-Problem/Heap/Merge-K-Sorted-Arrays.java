// Sorting method

// Time Complexity: O((N * K) * log(N * K))
//     Space Complexity: O(N * K)
import java.util.*;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
         ArrayList<Integer> ans=new  ArrayList<Integer>();
        
        for(int i=0;i<k;i++){
            for(int j=0;j<kArrays.get(i).size();j++){
                ans.add(kArrays.get(i).get(j));
            }
        }
        Collections.sort(ans);
        return ans;
	}
}


// Divide and conquer method
/*
    Time Complexity: O((N * K) * log(K))
    Space Complexity: O((N * K )* log(K))

    Where K is the number of arrays and N is the average number of elements in every array.
*/

import java.util.ArrayList;

public class Solution 
{
	private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) 
	{
		ArrayList<Integer>ans = new ArrayList<Integer>();

		int n = a.size(), m = b.size();
		int i = 0, j = 0;

		// Traverse the both arrays.
		while (i < n && j < m) 
		{
			if (a.get(i) < b.get(j)) 
			{
				ans.add(a.get(i));
				i ++;
			} 
			else 
			{
				ans.add(b.get(j));
				j ++;
			}
		}

		// Add remaining elements of the first array.
		while (i < n) 
		{
			ans.add(a.get(i));
			i ++;
		}

		// Add remaining elements of the second array.
		while (j < m) 
		{
			ans.add(b.get(j));
			j ++;
		}

		return ans;
	}

	private static ArrayList<Integer>  mergeKSortedArraysHelper(ArrayList<ArrayList<Integer>> kArrays, int start, int end) 
	{
		// If there is only one array.
		if (start == end) 
		{
			return kArrays.get(start);
		}

		// If there are only two arrays, merge them.
		if (start + 1 == end) 
		{
			return merge(kArrays.get(start), kArrays.get(end));
		}

		int mid = start + (end - start) / 2;

		// Divide the arrays into two halves.
		ArrayList<Integer> first = mergeKSortedArraysHelper(kArrays, start, mid);
		ArrayList<Integer> second = mergeKSortedArraysHelper(kArrays, mid + 1, end);

		// Return the final merged array.
		return merge(first, second);

	}

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>>kArrays, int k) 
	{
		ArrayList<Integer> result = mergeKSortedArraysHelper(kArrays, 0, k - 1);
		return result;
	}
}
//Using heaps

import java.util.*;
/*
    Time Complexity: O((N * K) * log(K)) 
    Space Complexity: O(N * K)
    
    Where N is the total number of elements in all the arrays, and K is the number of arrays.
*/

// import java.util.*;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;


class Pair 
{
    public int first, second, third;

    Pair(int first, int second, int third) 
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}


// Implements Comparator interface for min-heap.
class PqComparator implements Comparator<Pair> 
{
    public int compare(Pair pair1, Pair pair2) 
    {
//         if (pair1.first < pair2.first) 
//         {
//             return -1;
//         }
//         if (pair1.first == pair2.first) 
//         {
//             return 0;
//         }
//         return 1;

//Sort way to write above code
        return (pair1.first - pair2.first); 

    }
}

public class Solution 
{

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Create a min heap to store atmost k heap nodes at a time.
        PriorityQueue<Pair> minHeap = new PriorityQueue < Pair>(new PqComparator());

        for (int i = 0; i < kArrays.size(); i++) 
        {
            minHeap.add(new Pair( kArrays.get(i).get(0), i, 0 ));
        }


        while (minHeap.isEmpty() == false) 
        {

            // Remove the minimum element from the heap.
            Pair curr = minHeap.remove();

            // i is the array number and j is the index of the removed element in the ith array.
            int i = curr.second;
            int j = curr.third;

            // Add the removed element to the output array.
            result.add(curr.first);

            // If the next element of the extracted element exists, add it to the heap.
            if (j + 1 < kArrays.get(i).size()) 
            {
                minHeap.add(new Pair( kArrays.get(i).get(j + 1),  i, j + 1 ));
            }
        }

        // Return the output array.
        return result;
    }
}
