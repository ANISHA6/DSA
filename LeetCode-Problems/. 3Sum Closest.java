import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int min_diff=Integer.MAX_VALUE;
        int closest_sum=0;
        int n=nums.length;

        for(int p1=0; p1<n-2; p1++){
            int p2=p1+1;
            int p3=n-1;
            while(p2<p3){
               int sum=nums[p1]+nums[p2]+nums[p3];
                if(sum<target){
                    p2++;
                }else if(sum>target){
                    p3--;
                }else return sum;
           int diff=Math.abs(sum-target);
                if(min_diff> diff){
                    min_diff=diff;
                    closest_sum=sum;
                }
            }
        }


return closest_sum;
        
    }
}
