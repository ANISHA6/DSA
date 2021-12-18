public class solution {
    
    public static boolean checkP(String st,int s,int e){
       
        if(s>=e){
            return true;
        }

       
        if(st.charAt(s)==st.charAt(e)){
           return checkP(st,s+1,e-1);
        }
        else{
            return false;
        }
       
    }

	public static boolean isStringPalindrome(String input) {
		// Write your code here
        // Method 1
        if(input.length()<=1){
            return true;
        }
        if(input.charAt(0)==input.charAt(input.length()-1)){
           return isStringPalindrome(input.substring(1,input.length()-1));
        }
        else{
            return false;
        }
       return true;
        //Method 2
        
      return checkP(input,0,input.length()-1);

	}
}
