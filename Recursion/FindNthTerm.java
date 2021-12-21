public class Solution {
    
    public static long helper( int start, int numberofblock, int n){
        if(numberofblock==n+1){
            return 0;
        }
        int i;
        long res=1;
       for(i=start;i<(start+numberofblock);i++){ // for third block i=4,noofblock=3 i.e=4*5*6  <4+3=7
           res*=i;
       }
       return res+helper(i,numberofblock+1,n);
    }

	public static long Fnth_term(int n) {
		//Your code goes here
        
        return helper(1,1,n);
	}

}
