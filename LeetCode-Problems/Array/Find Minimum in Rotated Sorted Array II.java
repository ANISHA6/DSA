//Recursive approach

class Solution {
    
    public int search(int[] arr, int l, int r){
        if(l==r){
            return arr[l];
        }
        int mid=l+(r-l)/2;
        if(arr[mid]>arr[r]) return search(arr, mid+1, r);
        if(arr[mid]<arr[r]) return search(arr, l, mid);
        return search(arr, l, r-1);
    }
    public int findMin(int[] nums) {
        
        
        return search(nums, 0, nums.length-1);
    }
}


//Iterative approach

class Solution {
   
    public int findMin(int[] arr){
        
        
        int l=0;
        int r=arr.length-1;
        
        while(l<r)
        {
             int mid=l+(r-l)/2;
        if(arr[mid]>arr[r]) l= mid+1;
        else if(arr[mid]<arr[r]) r= mid;
            else r--; //for the duplicate elements
        }
        return arr[l];
    }
}
