public class Solution {
  // TC:O(n^2)

	public static void printSubstrings(String str) {
		//Your code goes here
        int l=str.length();
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                System.out.println(str.substring(i,j+1));
            }
        }
        
       
        
	}

}
