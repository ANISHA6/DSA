//Method 1, using subtraction
/*
    Time complexity: O(N/M)
    Space complexity: O(1)

    Where 'N' is 'dividend' and 'M' is 'divisor'.
*/

public class Solution 
{
    public static int divideTwoInteger(int dividend, int divisor) 
    {
        // Initially store  whether dividend, divisor are negative or positive.
        
        boolean isDividendNegative = false;
        if(dividend < 0)
        {
            dividend *= -1;
            isDividendNegative = true;
        }

        boolean isDivisorNegative = false;
        if(divisor < 0)
        {
            divisor *= -1;
            isDivisorNegative = true;
        }

        int quotient = 0;

        while(dividend >= divisor)
        {
            dividend -= divisor;
            quotient += 1;
        }

        // Both are negative.
        if(isDividendNegative && isDivisorNegative)
        {
            return quotient;
        }

        // Both are positive.
        if(!isDividendNegative && !isDivisorNegative)
        {
            return quotient;
        }

        // One is negative and one is positive.
        return -1 * quotient;
    }
}

//Method 2, using bit masking

/*
    Time Complexity: O(1)
    Space Complexity: O(1)
*/

public class Solution 
{
    public static int divideTwoInteger(int dividend, int divisor) 
    {
        // Initially store  whether dividend, divisor are negative or positive.
        
        boolean isDividendNegative = false;
        if(dividend < 0)
        {
            dividend *= -1;
            isDividendNegative = true;
        }

        boolean isDivisorNegative = false;
        if(divisor < 0)
        {
            divisor *= -1;
            isDivisorNegative = true;
        }

        long b = divisor;
        long a = dividend;

        long quotient = 0;

        for(int i = 30; i >= 0; i--)
        {
            if((b<<i) <= a)//b*2^i <= a
            {
                a -= (b<<i);
                quotient |= (1<<i);//1*2^i
            }
        }

        // Both are negative.
        if(isDividendNegative && isDivisorNegative)
        {
            return (int)quotient;
        }

        // Both are positive.
        if(!isDividendNegative && !isDivisorNegative)
        {
            return (int)quotient;
        }

        // One is negative and one is positive.
        return -1*(int)quotient;
    }
}

// Bit masking
 

 

// In this case quotient is = ‘2^3 + 2^2 +2^0 =13 = floor(107/8)’.

 

// The intuition here is that we can find the largest power of 2’s which can satisfy the equation ‘dividend = divisor * maximum 2’s power + remainder’.

 

// If found we set ‘quotient’ to ‘quotient = quotient +  maximum 2’s power’.

 

// Below is the detailed algorithm: 

 

// Store the ‘IS_DIVIDEND_NEGATIVE = false’ and ‘IS_DIVISOR_NEGATIVE = false’.
// Check if the 'DIVIDEND' and 'DIVISOR' are positive or negative and update the values of ‘IS_DIVIDEND_NEGATIVE’ and  ‘IS_DIVISOR_NEGATIVE’.
// Use variable ‘QUOTIENT = 0’.
// Iterate a loop from ‘31’ to ‘0’ with ‘-1’ jumps (say iterator = ‘i’):
// If ( 'DIVISOR' << i <= 'DIVIDEND')
// Then ‘QUOTIENT = QUOTIENT + 1 << i’ and ‘DIVIDEND = DIVIDEND - DIVISOR << i’.
// If both ‘IS_DIVIDEND_NEGATIVE’ and ‘IS_DIVISOR_NEGATIVE’ are of the same sign:
// Return ‘QUOTIENT’
// Else, we need to make ‘QUOTIENT’ negative:
// Return ‘-1 * QUOTIENT’.
// Time Complexity
// O(1).

 

// Since we are using a loop of constant size ‘32’, the time complexity will be constant.

// Space Complexity
// O(1).

 

// Constant space is used.
