public class Solution {
    public static boolean isAble(int[] freq, int len){
        int odd_count=0;
        
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                odd_count++;
            }
        }
        if(len%2==0){
            if(odd_count>0){
                return false;
            }
            else 
                return true;
            
        }
        if(odd_count!=1){
            return false;
        }
        
        return true;
    }

	public static String nextPalindrome(String input) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        
        int len=input.length();
        int[] freq=new int[26];
        for(int i=0;i<len;i++){
            freq[input.charAt(i)-'a']++;
        }
        if(!isAble(freq,len)){
            return "";
        }
        String odd="";
        
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                freq[i]--;
                odd+=(char)(i+'a');
            }
        }
        
        String front="", rear="";
        
        for(int i=0;i<26;i++){
            String temp="";
            if(freq[i]!=0){
                char ch=(char)(i+'a');
                for(int j=1;j<=freq[i]/2;j++){
                    temp+=ch;
                }
                front+=temp;
                rear=temp+rear;
            }
            
        }
        return front+odd+rear;
  }
}
        
