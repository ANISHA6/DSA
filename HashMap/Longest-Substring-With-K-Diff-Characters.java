import java.util.*;
public class Solution {
    
    public static int helper(String str, int k, int n){
        if(n==0||k==0 || k>n){
            return -1;
        }
        Set<Character> window=new HashSet<>();
        int[] arr=new int[26];
        int size=-1;
        //low and high for maintaining the window size
        for(int low=0, high=0;high<n;high++){
            window.add(str.charAt(high));
            arr[str.charAt(high)-'a']++;
            
            if(window.size()>k){
           if(--arr[str.charAt(low)-'a']==0){
                
                window.remove(str.charAt(low));
           }
               low++;
            
            }
            
            if(size<high-low+1 && window.size()==k){
                size=high-low+1;
            }
        }
        return size;
    }


	public static void main(String[] args) {
		/* 
			* Your class should be named Solution.
			* Read input as specified in the question.
			* Print output as specified in the question.
			* Write your code here
		 */
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t!=0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            String str=sc.next();
           System.out.println(helper(str, K, N));
            t--;
        }

	}

}
