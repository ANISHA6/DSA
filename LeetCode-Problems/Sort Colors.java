class Solution {

      public static void swap(int[] a,int s, int e){
        int temp=a[s];
        a[s]=a[e];
        a[e]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int curr=0;
        int zero=0;
        int two=n-1;

        while(curr<=two){
            if(nums[curr]==0){
                swap(nums,zero,curr);
                zero++;
                curr++;


            }else if(nums[curr]==2){
                swap(nums, two, curr);
                two--;
            }else curr++;
        }


        
    }
}
