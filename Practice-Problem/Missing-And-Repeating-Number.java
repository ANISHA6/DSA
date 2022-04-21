//Method 1

/*
    Time complexity: O(N*N) 
	Space complexity: O(1)
	
	Where N is the length of the given array. 
*/

import javafx.util.Pair;
import java.util.ArrayList;

public class Solution {

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        int r = 0, m = 0;

        // Checking for the repeating number
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                int x = arr.get(i);
                int y = arr.get(j);
                if (x == y) {
                    r = arr.get(i);
                    break;
                }
            }
        }

        // Calculating the sum of the array
        int currSum = 0;
        for (int i = 0; i < n; i += 1) {
            currSum += arr.get(i);
        }

        // Sum of the numbers from 1 to n
        int actualSum = n * (n + 1) / 2;

        m = actualSum - (currSum - r);

        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(m, r);

        return ans;

    }
}

//Method 2 , using sorting

/*
    Time complexity: O(N*log(N)) 
	Space complexity: O(1)
	
	Where N is the length of the given array. 
*/

import javafx.util.Pair;
import java.util.*;

public class Solution {

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        int r = 0, m = 0;

        Collections.sort(arr);

        for (int i = 0; i < n - 1; i += 1) {

            int x = arr.get(i);
            int y = arr.get(i + 1);

            // Checking if two adjacent numbers are same
            if (x == y) {
                r = arr.get(i);

                break;
            }
        }

        // Calculating the sum of the array
        int currSum = 0;
        for (int i = 0; i < n; i += 1) {
            currSum += arr.get(i);
        }

        // Sum of the numbers from 1 to n
        int actualSum = (n * (n + 1)) / 2;
        currSum -= r;
        m = actualSum - (currSum);

        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(m, r);

        return ans;

    }
}

//Method 3, Frequency count

/*
    Time complexity: O(N) 
	Space complexity: O(N)
	
	Where N is the length of the given array. 
	
*/

import javafx.util.Pair;
import java.util.ArrayList;

public class Solution {

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {

        // Vector to store the count of the every element of the array
        ArrayList<Integer> countNumbers = new ArrayList<Integer>();

        for (int i = 0; i < n + 1; i++) {
            countNumbers.add(0);
        }

        for (int i = 0; i < n; i += 1) {
            int x = arr.get(i);
            int y = countNumbers.get(x);

            countNumbers.set(x, y + 1);
        }

        int r = 0, m = 0;

        for (int i = 1; i <= n; i += 1) {
            // The the count of the number is zero, it is the missing number
            if (countNumbers.get(i) == 0) {
                m = i;
            }

            // The the count of the number is two, it is the repeating number
            if (countNumbers.get(i) == 2) {
                r = i;
            }
        }

        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(m, r);

        return ans;

    }

}

//Method 4, Using xor, most optimal one

/*
    Time complexity: O(N) 
	Space complexity: O(1)
	
	Where N is the length of the given array. 
	
*/

import javafx.util.Pair;
import java.util.ArrayList;

public class Solution {
    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        int findXOR = 0;

        // Calculating the XOR of all the numbers from 1 to n
        for (int i = 1; i <= n; i += 1) {
            findXOR ^= i;
        }

        // Calculating the XOR of all the elements of the array
        for (int i = 0; i < n; i += 1) {
            findXOR ^= arr.get(i);
        }

        // last set bit of findXOR
        int bitIndex = findXOR & ~(findXOR - 1);

        int bitSet = 0, bitNotSet = 0;

        // Dividing the elements of the array in two sets, bitSet and bitNotSet
        for (int i = 0; i < n; i++) {
            if ((arr.get(i) & bitIndex) > 0) {
                bitSet = bitSet ^ arr.get(i);
            }

            else {
                bitNotSet = bitNotSet ^ arr.get(i);
            }
        }

        // Dividing the elements from 1 to n in two sets
        for (int i = 1; i <= n; i++) {
            if ((i & bitIndex) > 0) {
                bitSet = bitSet ^ i;
            }

            else {
                bitNotSet = bitNotSet ^ i;
            }
        }

        int r = 0, m = 0;

        for (int i = 0; i < n; i += 1) {
            // If bitSet is present in the array, it is the repeating number and bitNotSet
            // Is the missing number
            if (bitSet == arr.get(i)) {
                r = bitSet;
                m = bitNotSet;
                break;
            }

            // If bitNotSet is present in the array, it is the repeating number and bitSet
            // is the missing number
            if (bitNotSet == arr.get(i)) {
                r = bitNotSet;
                m = bitSet;
                break;
            }
        }

        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(m, r);

        return ans;

    }

}


XOR Method
We know that XOR of a number with itself is 0. 

Now, let's start with the algorithm.

 

Calculate XOR of all the elements of the array.
findXOR = arr[0]^arr[1]^arr[2]…..arr[n-1]
        Now, XOR the result with all numbers from 1 to n.
        findXOR = (findXOR)^1^2^…..^n.

Now, findXOR will contain the XOR of the missing number and the repeating number as all the numbers would nullify each other.
All the set bits in findXOR will be in either the missing number or the repeating number. Using any set bit in the findXOR, let's say the rightmost set bit, we can divide the elements of the given array in two sets.
In the first set, we have the elements with the same bit set.
In the second set, we have all the elements with the same bit not set.
Initialize two variables, ‘bitSet’ and ‘bitNotSet’ with 0.
Traverse the given array and if the element belongs to the first set, take its XOR with bitSet else take its XOR with bitNotSet.
Traverse from 1 to n, and if the number belongs to the first set, take its XOR with bitSet else take its XOR with bitNotSet.
Now, we have our missing and repeating numbers stored in bitSet and bitNotSet, but we do not know which one is missing and which one is repeating.
To find which one is repeating, we will again traverse the given array and if ‘bitSet’ is present in the array, it means ‘bitSet’ is our repeating number and ‘bitNotSet’ is our missing number. We will store ‘bitSet’ in the variable ‘R’ and ‘bitNotSet’ in the variable ‘M’. If ‘bitNotSet’ is present in the array, it means ‘bitNotSet’ is our repeating number and ‘bitSet’ is our missing number. We will store ‘bitSet’ in the variable ‘M’ and ‘bitNotSet’ in the variable ‘R’.
Finally, we will return the missing number ‘M’ and the repeating number ‘R’.

 

For example: 

If the given array is [1, 3, 5, 3, 4] 

Then, findXOR = [1 ^ 2 ^ 3 ^ 4 ^ 5] ^ [ 1 ^ 3 ^ 5 ^ 3 ^ 4]  = 1

Notice that, 2 is our missing number and 3 is our repeating number in the given array and 2^3 is 1. 

Now, the first bit is set in 1. 

We will traverse the array and find all the elements whose this bit is set and take their XOR and store it in A. Also, we will take the XOR of all the elements in the array and from 1 to n whose this bit is not set and store it in B. 

A =  [ 1 ^ 3 ^ 3 ^ 5 ] ^ [ 1 ^ 3 ^ 5] = 3

B =  [ 4 ] ^ [ 2 ^ 4] = 2 

As 3 is present in the array, this cant be our missing number. 

Thus, 2 is our missing number and 3 is our repeating number.

Time Complexity
O(N), where N is the number of elements in the given array.

 

We are traversing the given array a few times and we are also traversing from 1 to n. 

Thus, the final time complexity is O(N).

Space Complexity
O(1) 

 

We are not using any extra data structure. Only constant additional space is required.

