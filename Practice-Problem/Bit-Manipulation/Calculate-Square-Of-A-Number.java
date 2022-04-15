//Method 1, using addition

/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where N is the given integer.
*/

import java.util.*;
import java.lang.*;

public class Solution 
{

	public static int calculateSquare(int num) 
	{
		if (num < 0) 
		{
			num = -1 * num;
		}

		// Stores square of the number.
		int numSquare = num;

		// Repeatedly add num to the result.
		for (int i = 1; i < num; i++) 
		{
			numSquare = numSquare + num;
		}

		return numSquare;
	}
}

//Method 2, using sum of odd numbers
/*
    Time Complexity: O(N)
    Space Complexity: O(1)
    
    Where N is the given integer.
*/

import java.util.*;
import java.lang.*;

public class Solution 
{

	public static int calculateSquare(int num) 
	{
		// Convert number to positive if it is negative.
		if (num < 0) 
		{
			num = -num;
		}

		int odd = 1;
		int numSquare = 0;

		// Add first num odd numbers to the result.
		while (num > 0) 
		{
			numSquare = numSquare + odd;
			odd = odd + 2;
			num -= 1;
		}

		return numSquare;
	}
}





//Method 3, Bitwise operator
/*
    Time Complexity: O(log N)
    Space Complexity: O(log N)

    Where N is the given integer.
*/

import java.util.*;
import java.lang.*;

public class Solution 
{

	public static int calculateSquare(int num) 
	{

		if (num < 0) 
		{
			num = -num;
		}

		// Base case.
		if (num == 0) 
		{
			return 0;
		}

		// Get floor(num/2) using right shift.
		int f = num >> 1;

		// If n is odd
		if ((num & 1) == 1) 
		{
			return ((calculateSquare(f) << 2) + (f << 2) + 1);
		}
		// If n is even.
		else 
		{
			return (calculateSquare(f) << 2);
		}
	}
}





// Bitwise Operators
// Our main approach here is to use bitwise operators. Let’s take a look at even and odd numbers individually.

 

// Firstly if ‘N’ is even:

// For a number to be even it needs to be a multiple of 2. So ‘N’ can be written as 2*C, where C is an integer.

// Now N^2 will be (2*C)^2 = 4*C^2.

 

// Secondly if ‘N’ is odd:

// Since we know the odd number is nothing but an even number + 1. So ‘N’ can be expressed as 2*C + 1, where C is an integer.

// Now N^2 will be (2*C + 1)^2  = 4*C^2 + 4*C + 1.

 

// The steps are as follows:
 

// Let’s define a function square(X), which returns the square of any integer X.
// The base case is when N is 0 so we need to return 0.
// Now when ‘N’ is even, return 4*square(N / 2) i.e (square(N >> 1) << 2) (using bitwise shift operator).
// Else if the given number ‘N’ is odd return 4*square(floor(N / 2)) + 4*floor(N / 2) + 1 i.e. ((square(N >> 1) << 2) + ((N >> 1) << 2) + 1).
 

// In the code implementation, we’ll use the right shift operator (>>) to calculate the floor(N / 2).

 

// An edge case is when the integer is negative. We also know that the square of ‘N’ and ‘-N’ is the same, so whenever we are given a negative integer, we will convert it to a positive integer.

// Time Complexity
// O(log N), where ‘N’ is the given integer.

 

// Since we are going through ‘log N’ iterations because each time we are dividing N by 2, so the overall time complexity will be O(log N).

// Space Complexity
// O(log N), where ‘N’ is the given integer.

 

// The size of the recursion stack will be at most log N, thus, the overall space complexity will be O(log N).

