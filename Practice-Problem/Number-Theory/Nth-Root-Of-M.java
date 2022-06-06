//Code not working for some test cases.
public class Solution {
    
    public static double multilpy(double num, int n){
        double ans=1.0;
        
        for(int i=0;i<n;i++){
            ans=ans*num;
        }
        return ans;
    }
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        
        double low=1;
        double high=m;
        double eps=1e-7;
        
        while((high-low)>eps){
            double mid=(low+high)/2.0;
            if(multilpy(mid,n)<m){
                low=mid;
            }else
                high=mid;
        }
        return low;
    }
}
