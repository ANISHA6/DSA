public class Solution {
    public static void swap(int[] a,int s, int e){
        int temp=a[s];
        a[s]=a[e];
        a[e]=temp;
    }

    public static void sort012(int[] arr){
    	//Your code goes here
        //In place of switch we can also use if else condition
        int n=arr.length;
        int zerop=0;
        int curr=0;
        int twop=n-1;
        while(curr<=twop){
            switch(arr[curr]){
                case 0:{
                    swap(arr,zerop,curr);
                    zerop++;
                    curr++;
                    break;
            } 
                case 1:{
                    curr++;
                    break;
                }
                case 2:{
                    swap(arr,curr,twop);
                    twop--;
                    break;
                }
            }
        }
    }

}
