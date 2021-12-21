public class Solution {
    
    public static void helper(int digit, int sum ,String ans){
       if(digit>0 && sum>=0){
           char l='0';
           if(ans=="") // Number can't be start with 0
               l='1';
           for(;l<='9';l++){
               helper(digit-1,sum-(l-'0'),ans+l);
           }
           
       }
        else if(digit==0 && sum==0){
            System.out.println(ans+" ");
        }
    }
        

	public static void find(int digits, int sum) {
		//Your code goes here
        
        helper(digits,sum ,"");
	}
}
