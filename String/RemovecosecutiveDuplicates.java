public class Solution {

	public static String removeConsecutiveDuplicates(String str) {
		//Your code goes here
        // TC:=O(N)
        int n=str.length();
        //First way to write the code 
        if(n==0){
             return str;
        }
        String ans="";
        int si=0;
        while(si<n){
            char uniquechar=str.charAt(si);
            int nextucharindex=si+1;
            while(nextucharindex<n &&(str.charAt(nextucharindex)==uniquechar)){
                nextucharindex++;
            }
            ans+=uniquechar;
            si=nextucharindex;
        }
        return ans;
        
        
        //second way to write the code
        String ans="";
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                continue;
            }
            else{
                ans+=str.charAt(i);
            }
        }
        ans+=str.charAt(n-1);
        return ans;
	}

}
