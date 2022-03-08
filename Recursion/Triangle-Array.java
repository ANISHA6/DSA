import java.util.*;
public class Solution {
    
    public static int helper(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        
        int[] op=new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            op[i]=(arr[i]+arr[i+1])%1000000007;
        }
        int a=helper(op);
        return a;
    }
	public static void main(String[] args) {
		//Your code goes here
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
            
        }
      int ans=helper(arr);
        System.out.println(ans);
        
        
	}
}
