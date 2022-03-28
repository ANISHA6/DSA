//Method 1
//Below is the explanation of method 1

// (Divide and conquer):
// This approach is based on recursion. We first divide the whole array of strings into two parts.
// Then we will do the same for the left part as well for the right part after that. We will continue
// doing this until we get all the strings of length 1. Now, we will start conquering by return the
// common prefix of the left and the right parts.
// Time Complexity: As we are iterating through all the strings, and for each string, we are iterating
// through each of the characters. So, the time complexity is, O(number of strings* length of the
// largest string).
// Space Complexity: The auxiliary space which we are using, to store the longest prefix is
// O(length of the largest string* log(number of strings)).
	
	
	
	
	
public class Solution {
    private static String com_prefix(String op1, String op2){
        String out="";
        int n1=op1.length(), n2=op2.length();
        for(int i=0,j=0;i<n1 && j<n2;i++, j++){
            if(op1.charAt(i)!=op2.charAt(j)){
                break;
            }
            out=out+op1.charAt(i);
        }
        return out;
    } 
    private static String divide(String input[], int start, int end){
        if(start==end){
            return input[start];
        }
        if(end>start){
            int mid=start+(end-start)/2;
            String op1=divide(input,start,mid);
            String op2=divide(input,mid+1,end);
            return com_prefix(op1, op2);
        }
        return "";
    }

	public static void answer(String input[]) {
		//Your code goes here
        
        String output=divide(input,0,input.length-1);
        System.out.println(output);
	}
}

//Method 2

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
	    //Assuming, 1st string is common prefix among all the string
        String pref=strs[0];
        
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(pref)!=0){//0 ,means pref is present in strs[i], so no need to remove last character from pref
                pref=pref.substring(0, pref.length()-1);
            }
        }
        return pref;
        
    }
}
