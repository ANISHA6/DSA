public class Solution {
    
    public static double helper(int N) {//log(n!)=log(n)+log(n-1)+log(n-2)+....1
		//Your code goes here
        
        if(N==1)
            return 0;
	
    double ans=helper(N-1);
    return (Math.log(N))+ans;
    }

	public static long lnfact(int N) {
		//Your code goes here
        
       return (long)helper(N);
    }
 }
