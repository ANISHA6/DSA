public class Solution {

	public static String recurr(int num, int den) {
		// TODO Auto-generated method stub
        //1888/3 = 629.333333333...... 
        //Recurring sequence is 3.
        
        String ans="";
        HashMap<Integer, Integer> map=new HashMap<>();
        int rem=num%den;
        while(rem!=0 &&(map.containsKey(rem)==false)){
            map.put(rem,ans.length());
            rem=rem*10;
            int q=rem/den;
            ans+=Integer.toString(q);
            rem=rem%den;
        }
        
		return (rem==0)?" ":ans;
	}

}
