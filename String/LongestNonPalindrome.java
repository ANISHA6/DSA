public class Main {
    public static boolean isPalindrome(String str){
        
        int si=0;
        int ei=str.length()-1;
        while(si<=ei){
            if(str.charAt(si)!=str.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
    public static int LongestNonPalindromicstring(String str){
        int len=str.length();
        char firstChar=str.charAt(0);
        int i=0;
        for(i=1;i<len;i++){
            if(str.charAt(i)!=firstChar){
                break;
            }
        }
        if(i==len){
            return 0;
        }
        if(isPalindrome(str)){
            return len-1;
        }
         return len;
    }
}
