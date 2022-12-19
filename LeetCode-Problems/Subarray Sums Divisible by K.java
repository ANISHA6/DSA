class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }


        int[] count=new int[k];// It will strore counts of all the remainder from 0 to k-1
        int sum=0;
        
        for(int x:nums){
            sum+=(x%k + k)%k; //+k, doing for -ve number
            count[sum % k]++;
        }
        int result=count[0];// if sum is zero, ncn + n

        for(int j=0;j<k;j++){
            int c=count[j];
            result+=(c*(c-1))/2;// if sum is not zero, nc2
        }
        return result;
        
    }
}
