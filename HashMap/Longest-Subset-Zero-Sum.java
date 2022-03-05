import java.util.*;
public class Solution {

	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		// Write your code here
    //subset means discontinuous but here we have to take continuous
        
        int ml=0;
        int n=arr.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);//to handle, if sum is zero from index 0 to x, x-(-1)=x+1
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int l=0;
            if(map.containsKey(sum)){
                l=Math.abs(i-map.get(sum));
            }
            else
                map.put(sum,i);
            
            if(l>ml){
                ml=l;
            }
            
        }
        return ml;
        
	}
}
