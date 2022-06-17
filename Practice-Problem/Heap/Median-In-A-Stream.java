//Brute force approach

/*

	Time complexity: O(N*(N*log(N))) 
	Space complexity: O(N)
	
	where N is the total number of elements in the array.

*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {

        // To store the incoming stream elements
        ArrayList<Integer> store = new ArrayList<Integer>();

        // To store the medians
        int[] medians = new int[n];

        for (int i = 0; i < n; i++) {

            // Storing the incoming data from stream in a vector 'store'
            store.add(arr[i]);

            // Sorting the vector to arrange all the elements in sorted order
            Collections.sort(store);

            int median;
            // Even number of elements are read, (Note - 0 based indexing is used)
            if ((i + 1) % 2 == 0) {

                // Average of middle two values
                median = (store.get(i / 2) + store.get((i + 1) / 2)) / 2;

            }
            // odd number of elements are read
            else {

                // The middle value of the sorted arrangement of the elements read so far
                median = store.get(i / 2);

            }

            medians[i] = (median);

        }

        return medians;
    }
}


//Using max and min heap

/*

	Time complexity: O(N*(log(N))) 
	Space complexity: O(N)
	
	where N is the total number of elements in the array.

*/

/*

	Time complexity: O(N*(log(N))) 
	Space complexity: O(N)
	
	where N is the total number of elements in the array.

*/

import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {

    public static int[] findMedian(int[] arr, int n) {

        // To store the medians
        int[] medians = new int[n];

        // min heap
        PriorityQueue<Integer> lo = new PriorityQueue<>();

        // max heap
        PriorityQueue<Integer> hi = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {

            int num = arr[i];

            // Add to max heap
            lo.add(num);

            // Balancing step, that is inserting the current element at its position that is
            // either less than median or more than median value
            hi.add(lo.poll());

            // Maintain size property, as 'lo' can have utmost one more element than 'hi' or
            // both have equal number of elements
            if (lo.size() < hi.size()) {
                lo.add(hi.poll());

            }

            int median;

            // For odd number of elements
            if (lo.size() > hi.size()) {

                median = lo.peek();

            }
            // For even number of elements
            else {

                median = (lo.peek() + hi.peek()) / 2;

            }

            medians[i] = median;
        }

        return medians;

    }

}

