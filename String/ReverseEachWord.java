public class Solution {

	public static String reverseEachWord(String str) {
		//Your code goes here
        
        
        String ans="";
        int start=0;
        int end=0;
        int i=0;
        int len=str.length();
    
        for(;i<len;i++){
            if(str.charAt(i)==' '){
                end=i-1;
            String rev=""; 
                for(int j=start;j<=end;j++){
                    rev=str.charAt(j)+rev;  // write like this if we want to reverse string left to right
                    // rev+=str.charat(i); for right to left
                }
                start=i+1;
                ans+=rev+" ";
            }
        }
        // Code for last word
        String revLastword="";
       // for(int j=start;j<=i-1;j++)
        int s=start;
        int e=i-1;
        for(int j=s;j<=e;j++){
        
        
            revLastword=str.charAt(j)+revLastword;
            
        }
        ans+=revLastword;
        return ans;
	}

}
