public class Solution {
    
    //TC:O(N), SC:O(1)
    // Calling it inplace heap sort because we are not using any extra space here, to sort the heap
    public static void downHeapify(int[] arr, int i, int n){
        
        int pi=i;
        int lc=pi*2+1;
        int rc=pi*2+2;
        
        while(lc<n){
            int min=pi;
            if(arr[lc]<arr[pi]){
                min=lc;
            }
            if(rc<n && arr[rc]<arr[min]){
                min=rc;
            }
            if(min==pi){
                return;
            }
            int temp=arr[pi];
            arr[pi]=arr[min];
            arr[min]=temp;
            pi=min;
            lc=pi*2+1;
            rc=pi*2+2;
        }
    }

	public static void inplaceHeapSort(int arr[]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
        
		*/
        int n=arr.length;// Given array, consider it as a heap don't have to use any extra space or heap
        for(int i=n/2-1;i>=0;i--){//start working from non leaf node
            downHeapify(arr,i,n);
        }
        //Remove elements fron startig one by one and put them at respective position
      for(int i=n-1;i>=0;i--){
          int temp=arr[i];
          arr[i]=arr[0];
          arr[0]=temp;
          downHeapify(arr,0,i);
      }        
		
	}
}
