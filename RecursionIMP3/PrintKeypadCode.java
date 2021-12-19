public class solution {
    
    public static String getstring(int l){
        String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};// phone keypad
        return arr[l];
    }
    public static void print(int n, String o){
        if(n==0){
            System.out.println(o);
            return;
        }
        int lastDigit=n%10;
        String str=getstring(lastDigit);
        for(int i=0;i<str.length();i++){
            print(n/10,str.charAt(i)+o); //One digit has atleast 3 or 4 characters, so calling for each characters
}                                        // so TC:O(4^n), n=no of digit
    }

	public static void printKeypad(int input){
		// Write your code here
        print(input,"");
		
	}
}
