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
