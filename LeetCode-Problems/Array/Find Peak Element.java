class Solution {
    public int findPeakElement(int[] nums) {
          int left=0,right=nums.length-1;
        while(left<right){
            int midIndex=left+(right-left)/2;
            if(nums[midIndex]>nums[midIndex+1])
                right=midIndex;
            else
                left=midIndex+1;
        }
        return right;
    }
}
