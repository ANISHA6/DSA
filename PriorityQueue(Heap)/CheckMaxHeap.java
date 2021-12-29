public class Solution {

	public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
        int n=arr.length;
        
        for(int i=0;2*i+1<n;i++){
            int leftchild=2*i+1;
            int rightchild=leftchild+1;
            if(arr[leftchild]>arr[i]){//if leftchild greater than parent then return false
                return false;
            }
            //if rightchild exists and greater than parent then return false
            if(rightchild<n &&(arr[rightchild]>arr[i])){
                return false;
            }
        }
        return true;
	}
}
