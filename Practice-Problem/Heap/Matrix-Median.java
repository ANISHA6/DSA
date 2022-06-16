/Method 1
  /*
    Time Complexity : O(N * M * log(N * M))
    Space Complexity : O(N * M)
    
    Where 'N' is the number of rows 
    and 'M' is the number of columns in the given matrix.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{

	public static int getMedian(ArrayList<ArrayList<Integer>> matrix) 
	{

		int n = matrix.size();
		int m = matrix.get(0).size();

		// ArrayList to store the elements in given matrix.
		ArrayList<Integer> data = new ArrayList<Integer>();

		// Iterate through matrix and push elements in the vector.
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < m; j++) 
			{
				data.add(matrix.get(i).get(j));
			}
		}

		// Sort the vector of elements in non-decreasing order.
		Collections.sort(data);

		// Return the median which is (N*M)/2 th element in the vector.
		return data.get((n * m) / 2);
	}
}


//Method 2- Using priority queue


/*
    Time Complexity : O(N * M * log(N))
    Space Complexity : O(N)

    Where 'N' is the number of rows
    and 'M' is the number of columns in the given matrix.
*/

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {

		int n = matrix.size();
		int m = matrix.get(0).size();

		// Create Min Heap.
		PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
				int x = a1.size();
				int y = a2.size();
				if (y < x)
					x = y;
				for (int i = 0; i  < x; i++) {
					if (a1.get(i) > a2.get(i))
						return 1;
					if (a1.get(i) < a2.get(i))
						return -1;

				}
				return 0;
			}
		});

		// Push the all the row.
		for (int j = 0; j < n; j++) {
			minHeap.offer(matrix.get(j));
		}

		int count = 0;
		int median, num;

		while (true) {
			ArrayList<Integer> row = minHeap.poll();

			count = count + 1;

			// Remove first element of the row.
			num = 0;
			if (row.size() > 0) {
				num = row.get(0);
				row.remove(0);
			}

			if (count == (n * m) / 2 + 1) {
				// The current element is the middle element i.e. the overall median of the
				// matrix.
				median = num;
				break;
			}

			// Insert the row.
			if (row.size() > 0) {
				minHeap.offer(row);
			}
		}
		return median;
	}
}
