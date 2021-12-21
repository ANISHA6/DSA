public class Solution {

    public static int len(int n){
        int l=0;
        while(n!=0){
            l++;
            n=n/10;
        }
        return l;
    }
	public static int reverseInteger(int num) {
		//Your code goes here
        int length=len(num);
        if(length==1){
            return num;
        }
        int ans= reverseInteger(num/10);
        return  num%10*((int)Math.pow(10,length-1))+ans;
	}

}
