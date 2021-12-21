public class Solution {
    public static void helper(int one, int zero, String ans, int n){
        if(one<zero){
            return;
        }
        if(one>=zero &&(one+zero)==n){
            System.out.println(ans);
            return;
        }
        helper(one+1,zero,ans+'1',n);
        helper(one,zero+1, ans+'0',n);
        return;
    }
	public static void printBinary(int n) {
		//Your code goes here
        
        helper(0,0,"",n);
	}
}
//You are given an integral value n, you have to find all n-digit binary numbers such that the binary number must have more 1's than 0's for any prefix of the number.
