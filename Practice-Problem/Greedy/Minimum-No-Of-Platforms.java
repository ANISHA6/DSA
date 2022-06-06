import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        
        int plat_needed=0;
        int result=0;
        int i=0, j=0;
        
        while(i<n && j<n){
            if(at[i]<=dt[j]){
                plat_needed++;
                i++;
            }else if(at[i]>dt[j]){
                plat_needed--;
                j++;
            }
            if(plat_needed>result){
                result=plat_needed;
            }
        }
        return result;
        
    }
}
