//Method 1, using insertion sort
import java.util.*;
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
		int i=0;
		int j=0;
		while(i<m && j<n){
			if(arr1[i]<arr2[j]){
				i++;
			}else{
				int temp=arr1[i];
				arr1[i]=arr2[j];
				arr2[j]=temp;
				Arrays.sort(arr2);
				i++;
			}
		}
		int k=m;
		for(int x=0;x<n;x++){
			arr1[k++]=arr2[x];
		}
		return arr1;
    }
}


//Method 2, Brute force approach

/*
	Time complexity: O((M+N) * log(M+N))
	Space complexity: O(1)

	Where M and N are the number of elements in ARR1 and ARR2 respectively.
*/

import java.util.Arrays;

public class Solution {
	public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {

		for (int i = 0; i < n; i++) {
			arr1[i + m] = arr2[i];
		}

		Arrays.sort(arr1);
		return arr1;

	}
}


//Method 3, Greedy approach
/*
	Time complexity: O(M+N)
	Space complexity: O(1)

	Where M and N are the number of elements in ARR1 and ARR2 respectively.
*/

public class Solution {
	public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {

		int i = m - 1;
		int j = n - 1;
		int lastIndex = m + n - 1;

		while (j >= 0) {

			if (i >= 0 && arr1[i] > arr2[j]) {
				arr1[lastIndex] = arr1[i];
				i--;
			} else {

				arr1[lastIndex] = arr2[j];
				j--;
			}

			lastIndex--;
		}
		return arr1;

	}
}
