 public static int findpivot(int[] arr, int lo, int hi){
        if(lo==hi){
            return lo;
        }
        int mid=(lo+hi)/2;
        int pre=(mid-1+arr.length)%arr.length;
        int next=(mid+1)%arr.length;
        if(arr[mid]>arr[pre] && arr[mid]>arr[next]){
            return mid;
        }
         else if(arr[mid]<arr[lo]){
            return findpivot(arr,lo,pre);
        }
        else{
            return findpivot(arr,next,hi);
        }
    }

    public static int search(int[] arr, int k){
    int n=arr.length;
        if(n==0){
            return -1;
        }
        //1. find pivot ,Max element in array
        // search in first half
        // search in second half
        int pivot=findpivot(arr,0,n-1);
        // end index not inclusive
        int firstHalf=Arrays.binarySearch(arr,0, pivot+1,k);
        if(firstHalf>=0){
            return firstHalf;
        }else{
            // start index inclusive
            // binarySearch rerurn -8 (- * the spot to insert missing value)
            int fh=Arrays.binarySearch(arr,pivot+1,n,k);
            return fh>=0?fh:-1;
        }
        
        
    
    }
	
