public class Solution {  

    public static void pushZerosAtEnd(int[] arr) {
    	//Your code goes here
        //TC:O(n) 
        int n=arr.length;
        int k=0;
        int i=0;
        while(i<n){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                i++;
                k++;
            }
            else
                i++;
        }
        
    }

}
