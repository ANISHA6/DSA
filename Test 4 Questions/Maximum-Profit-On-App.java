import java.util.*;
public class solution {
    public static int maximum(int budget[],int i,int m){
        if(budget.length==1){
            return budget[0];
        }
        if(budget.length==0){
            return 0;
        }
       if(i==budget.length){
            return m;
        }
        int x=budget[i];
        int y=0;
        for(int j=0;j<budget.length;j++){
            if(budget[j]>=x){
                y++;
            }
        }
        
            int ans=x*y;
            int ma=Math.max(m,ans);
        return maximum(budget,i+1,ma);
              
        }
    

	public static int maximumProfit(int budget[]) {
		// Write your code here
        
       // Method 1
        //In this method getting TLE, for some test cases
       int m=Integer.MIN_VALUE;
       int m=0;
      return  maximum(budget,0,m);
        
        
        //Method 2
    
        Arrays.sort(budget);
        int[] cost=new int[budget.length];
        for(int i=0;i<budget.length;i++){
            cost[i]=budget[i]*(budget.length-i);
        }
        int max=Integer.MIN_VALUE;
        for(int i:cost){
            if(i>max){
                max=i;
            }
            
        }
        return max;

	}

}
