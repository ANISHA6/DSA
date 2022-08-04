class Solution {
    public int[] rearrangeArray(int[] nums) {
        int idx1=-2;
        int idx2=-1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[idx1+=2]=nums[i];
            }else{
                ans[idx2+=2]=nums[i];
            }
        }
        return ans;
        
    }
}
