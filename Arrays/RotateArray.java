public class Solution {  
    public static void reverse(int[] a, int s, int n){
        int e=n-1;
        while(s<e){
            int temp=a[s];
            a[s]=a[e];
            a[e]=temp;
            s++;
            e--;
            
        }
        
    }

    public static void rotate(int[] arr, int d) {
    	//Your code goes here
        if(arr.length==0){
            return;
        }
        if(d>=arr.length && arr.length!=0){
            d%=arr.length;
        }
        int n=arr.length;
        reverse(arr,0,n);
        reverse(arr,0,n-d);
        reverse(arr,n-d,n);
        
    }

}
