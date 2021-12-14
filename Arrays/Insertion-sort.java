public class Solution {  

    public static void insertionSort(int[] arr) {
    	//Your code goes here
      // j part of array is sorted and after it, unsorted
      //Start inserting the element from unsorted portion to sorted portion
        int n=arr.length;
        int temp;
        for(int i=1;i<n;i++){
            temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }

}
