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

import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        PriorityQueue<Integer> max=new PriorityQueue<>();//By default max heap
        PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());// Making min heap by reversing it
        
        int[] medians=new int[n];
        
        for(int i=0;i<n;i++){
            int num=arr[i];
            max.add(num);
            min.add(max.poll());
            
            if(max.size()<min.size()){
                max.add(min.poll());
                
            }
            int median;
            if(max.size()>min.size()){
                median=max.peek();
            }else{
                median=(max.peek()+min.peek())/2;
            }
            medians[i]=median;
        }
        return medians;
        
    }
}
