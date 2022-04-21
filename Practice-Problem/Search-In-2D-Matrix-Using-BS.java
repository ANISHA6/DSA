/*
   Time Complexity : O(log(M*N))
   Space Complexity : O(1)

   Where M and N denote the number of rows and columns 
   in the given matrix.
*/

import java.util.*;
import java.io.*;

public class Solution {

	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
    //Here, every 1st element of row greater than the last elem of previous row if exist,
    //i.e, if i put in 1D array , it would be a sorted array, and on that we can perform binary search
    //but instead of using extra space for 1D
    //use imaginary index and, crossponding to that index find row and col for given 2D mat
    
    
		int start = 0, 
    end = m * n - 1;//imaginary last index of 1D array
    
    //Method to find row and col index
    //r=imaginary_index / total no of col
    //c=imaginary_index % total no of col

		// Binary search.
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int val = mat.get(mid / n).get(mid % n);

			if (target < val) {
				end = mid - 1;
			} else if (target > val) {
				start = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
