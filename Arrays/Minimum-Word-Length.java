public class Solution {
	
	public static String minLengthWord(String input){
		
		// Write your code here
        int len=input.length();
      
        String mins="";
        int si=0;
        int ei=0;
        int ml=len;
        int msi=0;
        while(ei<=len){
            if(ei<len && input.charAt(ei)!=' '){
                ei++;
            }
            else{
                int cl=ei-si;
                if(cl<ml){
                    ml=cl;
                    msi=si;
                }
                
                
            
            ei++;
            si=ei;
            }
        }
        mins=input.substring(msi,msi+ml);
        return mins;
        
     }
}
