import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        // Write your code here.
        int max=0;
        int[] msis=new int[n];
      
        for(int i=0;i<n;i++){
            msis[i]=rack.get(i);
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(rack.get(i)>rack.get(j) && msis[i]< msis[j]+rack.get(i)){
                    msis[i]= msis[j]+rack.get(i);
                }
            }
              
            
        }
        for(int i=0;i<n;i++){
            if(max<msis[i]){
                max=msis[i];
            }
        }
        return max;
    }
}
