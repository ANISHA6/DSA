public class Solution {
	public static String getCompressedString(String str) {
		// Write your code here
        if(str==null){
            return null;
        }
        if(str.length()==0){
            return "";
        }
        String ans="";
        int si=0;
        int ei=0;
        while(si<str.length()){
            while(ei<str.length()&&(str.charAt(si)==str.charAt(ei))){
                ei++;
            }
            int totalCharcount=ei-si;
            if(totalCharcount !=1){
                ans+=str.charAt(si)+""+totalCharcount ;
            }
            else
                ans+=str.charAt(si);
            si=ei;
        }
        return ans;
	}

}
