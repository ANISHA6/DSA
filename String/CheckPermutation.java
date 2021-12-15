// TC:O(N+M)
public class Solution {

	public static boolean isPermutation(String str1, String str2) {
		//Your code goes here
        int l1=str1.length();
        int l2=str2.length();
        if(l1!=l2){
            return false;
        }
        int freq[]=new int[256];
        for(int i=0;i<l1;i++){
            int index=str1.charAt(i);// Here we can also use char data type in place of int
            freq[index]+=1;
        }
        for(int j=0;j<l2;j++){
            int index1=str2.charAt(j);
            freq[index1]-=1;
        }
        for(int k=0;k<256;k++){
            if(freq[k]!=0){
                return false;
            }
        }
        return true;
	}

}
