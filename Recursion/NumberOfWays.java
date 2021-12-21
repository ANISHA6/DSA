public class Solution {
    
   public static int helper(int[] arr, int ts, int i, int sum){
         if(i>=arr.length){
            if(sum==ts)
                return 1;
            else
                return 0;
        }
        
       int x= helper(arr,ts,i+1,sum+arr[i]);
        int y=helper(arr,ts,i+1,sum-arr[i]);
       int z= helper(arr,ts,i+1,sum);
        return x+y+z;
    }

	public static int numberOfWays(int[] input, int sum) {
		//Your Code goes here
        
       int c= helper(input,sum,0,0);
        if(sum==0){
            return c-1;
        }
        return c;
	}
}
