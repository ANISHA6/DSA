public class Solution {
    public static void helper(String input, int i){
        
        if(input.length()==i){
            System.out.println(input);
            return;
        }
        
            char ch=input.charAt(i);
            if(ch=='?'){
                String ans1=input.substring(0,i)+'0'+input.substring(i+1);
                String ans2=input.substring(0,i)+'1'+input.substring(i+1);
                helper(ans1,i+1);
                helper(ans2,i+1);
                
                
            }
        else
            helper(input,i+1);
               
       
    }

	public static void printAllPossibleStrings(String str) {
		//Your code goes here
        
        helper(str,0);
	}

}
