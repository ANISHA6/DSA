//Brute force approach
/*
    Time Complexity - O(N^3)
    Space Complexity - O(1)

    Where N is size of the array "arr".
*/

import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {

				int currentProduct = 1;
				for (int k = i; k <= j; k++) {
					currentProduct = currentProduct * arr.get(k);
					ans = Math.max(ans, currentProduct);
				}
			}
		}

		return ans;
	}
}

//Optimized brute- force
/*
    Time Complexity - O(N^2)
    Space Complexity - O(1)

    Where N is size of the array "arr".
*/

import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int currentProduct = arr.get(i);
			ans = Math.max(ans, currentProduct);

			// Find all possible subarrays starting from this current index.
			for (int j = i + 1; j < n; j++) {
				currentProduct = currentProduct * arr.get(j);
				ans = Math.max(ans, currentProduct);
			}
		}

		return ans;
	}
}

//DP
/*
    Time Complexity - O(N)
    Space Complexity - O(1)

    Where N is size of the array "arr".
*/

import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

		int ans = Integer.MIN_VALUE;

		int productFromFront = 1, productFromBack = 1;

		for (int i = 0; i < n; i++) {
			productFromFront = productFromFront * arr.get(i);
			productFromBack = productFromBack * arr.get(n - i - 1);

			// Store the maximum of ans, productFromFront and productFromBack in the ans
			// variable.
			ans = Math.max(ans, Math.max(productFromFront, productFromBack));

			// If any of the products become 0, make them 1 again.
			if (productFromFront == 0) {
				productFromFront = 1;
			}
			if (productFromBack == 0) {
				productFromBack = 1;
			}
		}

		return ans;
	}
}

//Another way to write above code
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
        int ans=Integer.MIN_VALUE;
        
        int p=1;
        //Finding product from front 
         for(int i=0;i<n;i++){
             p*=arr.get(i);
             ans=Math.max(ans , p);
              if(p==0){
                 p=1;
             }
         }
        
        p=1;
        //Finding product from back
        
          for(int i=n-1;i>=0;i--){
              p*=arr.get(i);
              ans=Math.max(ans , p);
              if(p==0){
                 p=1;
             }
         }
        
        return ans;
        
	}
}
