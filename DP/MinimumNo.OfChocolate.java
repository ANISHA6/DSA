public class Solution {

	public static int getMin(int arr[], int N){
        
        
        int l=arr.length;
        int[] dp=new int[l];
        dp[0]=1;
        
        // Distributing chocalate from left side
    for(int i=1;i<l;i++){
        if(arr[i]>arr[i-1]){
            dp[i]=1+dp[i-1];
        }else
            dp[i]=1;
    }
        
        // Distributing chocalate from right side
        for(int i=l-2;i>=0;i--){
            if(arr[i]>arr[i+1] && dp[i]<=dp[i+1]){
                dp[i]=1+dp[i+1];
            }
        }
        int sum=0;
        for(int i=0;i<l;i++){
            sum+=dp[i];
        }
        return sum;
        
    }
}
