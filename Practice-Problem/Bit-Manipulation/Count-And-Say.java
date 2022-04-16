import java.util.*;
public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
        // Write your code here.
		if(n==1){
			return "1";
		}
		String st=writeAsYouSpeak(n-1);
		int count=0;
// 		String ans="";
		StringBuilder ans=new StringBuilder();

			for(int i=0;i<st.length();i++){
				count++;
				if(i==st.length()-1 || st.charAt(i)!=st.charAt(i+1)){
// 					ans=ans+count+st.charAt(i);
					ans.append(count).append(st.charAt(i));
					count=0;
				}
			}
		return ans.toString();
// 		return ans;
		
    }
}
