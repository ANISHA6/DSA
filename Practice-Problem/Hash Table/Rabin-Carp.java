import java.util.*;
/*
    Time Complexity: O(N*M)
    Space Complexity: O(N)

    Where 'N' is the length of the string 'str' and 'M' is the length of 'pat'
*/
public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
		ArrayList<Integer> ans=new ArrayList<>();
		
		int n=str.length();
		int m=pat.length();
		
		for(int i=0;i<=n-m;i++){
			String s="";
			int k=0;
			for(int j=i;j<n && k<m ;j++, k++){
				s+=str.charAt(j);
				}
				if(s.equals(pat)){
					ans.add(i);
				}
		}
				return ans;
	}
}
