//Iterative Approach
//Tc=O(N),  SC=O(1)
public class Solution {
    public static int atoi(String str) {
        // Write your code here.
        int sign=1;
        int res=0;
        int n=str.length();
        int i=0;
        if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        while(i<n){
            if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9){
                res=res*10+str.charAt(i)-'0';
            }
            i++;
        }
        return res*sign;
    }
}


//Recursive Approach
/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where 'N' is the length of the string.
*/

public class Solution {
	public static int atoi(String str) {
		boolean isNegative = false;
		int n = str.length();
		if (str.charAt(0) == '-') {
			isNegative = true;
		}

		// Store ans here.
		int ans1 = 0;

		int ans = atoiRecursive(str, n, 0, ans1);

		// If negative, make the number negative.
		if (isNegative) {
			return -1 * ans;
		} 
        else {
			return ans;
		}
	}

	private static int atoiRecursive(String str, int n, int curIdx, int ans) {

		// Base case (Only one digit).
		if (curIdx == n) {
			return ans;
		}

		// Recur for (n-1), multiply result with 10 and add last digit.
		if (str.charAt(curIdx) >= '0' && str.charAt(curIdx) <= '9') {
			ans = ans * 10 + str.charAt(curIdx) - '0';
			return atoiRecursive(str, n, curIdx + 1, ans);
		} 
        else {
			return atoiRecursive(str, n, curIdx + 1, ans);
		}
	}

}
