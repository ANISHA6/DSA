public class Solution {

	public static char highestOccuringChar(String str) {
		//Your code goes here
        int[] fre=new int[256];
        int maxfeq=0;
        for(int i=0;i<str.length();i++){
           
            fre[str.charAt(i)]+=1;
            maxfeq=Math.max(maxfeq,fre[str.charAt(i)]);
        }
       
        char ans='\0';
        for(int i=0;i<str.length();i++){
            if(fre[str.charAt(i)]==maxfeq){
                ans=str.charAt(i);
                break;
            }
        }
        return ans;
	}

}
