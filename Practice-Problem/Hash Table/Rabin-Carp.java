//Optimal solution

/*
    Time Complexity: O(N + M)
    Space Complexity: O(1)

    Where 'N' is the length of the string 'str' and 'M' is the length of pat
*/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {

		int prime = 31; //base
		int mod = 998244353;

		int m = pat.length();
		int n = str.length();

		// Array/list to store power of prime i.e 31^i
		ArrayList<Long> primePower = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			primePower.add((long) 0);
		}

		primePower.set(0, (long) 1);
		for (int i = 1; i < n; i++) {
			primePower.set(i, (primePower.get(i - 1) * prime) % mod);
		}

		// Store hash values for string 'str' till each index i starting from 0
		ArrayList<Long> h = new ArrayList<Long>();
		for (int i = 0; i < n + 1; i++) {
			h.add((long) 0);
		}

		for (int i = 0; i < n; i++) {
			h.set(i + 1, (h.get(i) + (str.charAt(i) - 'A' + 1) * primePower.get(i)) % mod);
		}

		// Finding the hash value of pattern
		long hashPattern = 0;
		for (int i = 0; i < m; i++) {
			hashPattern = (hashPattern + (pat.charAt(i) - 'A' + 1) * primePower.get(i)) % mod;
		}

		ArrayList<Integer> occurences = new ArrayList<Integer>();

		// Rolling hash
		for (int i = 0; i + m - 1 < n; i++) {
			long currentHash = (h.get(i + m) + mod - h.get(i)) % mod;

			// If a match is found, insert it in our answer
			if (currentHash == hashPattern * primePower.get(i) % mod) {
				occurences.add(i);
			}
		}

		return occurences;
	}
}

import java.util.*;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		// Write your code here.
		ArrayList<Integer> ans=new ArrayList<>();
		//Method 1, not working for some test cases
		
		int n=str.length();
		int m=pat.length();
		int d=31;
		int p=998244353;
		
		int patHash=0;
		int strHash=0;
		//Generating hash values for pattern and first window text
		for(int i=0;i<m;i++){
			patHash=patHash*d;
			strHash=strHash*d;
			
			patHash=patHash+((pat.charAt(i)-'A'+1)%p);
			strHash=strHash+ ((str.charAt(i)-'A'+1)%p);
		}
		
		for(int i=0;i<n-m;i++){
			if(patHash==strHash){
				ans.add(i);
			}
			if(i<n-m){
				strHash=strHash- ((str.charAt(i)- 'A' +1) * (int) Math.pow(d, m-1));
				strHash=strHash *d + (str.charAt(i+m)-'A'+1);
			}
		}
		
		
		//Method 2, TLE
// 		int n=str.length();
// 		int m=pat.length();
		
// 		for(int i=0;i<=n-m;i++){
// 			String s="";
// 			int k=0;
// 			for(int j=i;j<n && k<m ;j++, k++){
// 				s+=str.charAt(j);
// 				}
// 				if(s.equals(pat)){
// 					ans.add(i);
// 				}
// 		}
				return ans;
	}
}
