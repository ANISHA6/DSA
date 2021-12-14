import java.util.*;
public class Solution {  

    public static int secondLargestElement(int[] arr) {
    	//Your code goes here
        if(arr.length==0){
            return Integer.MIN_VALUE;
        }
        // Method 1, Using two variable
        // TC:O(n)
        int lar=arr[0], seclar=Integer.MIN_VALUE;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>lar){
                seclar=lar;
                lar=arr[i];
            }
            else if(arr[i]>seclar && arr[i]!=lar){
                seclar=arr[i];
            }
        }
        return seclar;
        
        
        
     // Method 2 using sorting
     // TC: O(nlogn)   
        Arrays.sort(arr);
        int sec=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            if(arr[i]!=arr[n-1]){
                return arr[i];
            }
            else continue;
        }
        return sec;
        
    }
}
