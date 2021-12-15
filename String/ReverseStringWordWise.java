public class Solution {
	public static String reverseWordWise(String input) {
		// Write your code here
        int n=input.length();
        
        int end=n;
        int i=n-1;
        String output="";
        while(i>=0){
            if(input.charAt(i)==' '){
                output+=input.substring(i+1,end)+" ";
                end=i;
            }
            i--;
            
        }
        
            output+=input.substring(i+1,end);
        return output;
