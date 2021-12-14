public class Solution {

    public static int arrayRotateCheck(int[] arr){
    	//Your code goes here
        
        // We can traverse the array from both side
        //From right side
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[n-1]){
                return i+1;
            }
        }
        
        //From left side
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }

}
