public class solution {
    
    public static String getstring(int index){
        String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return arr[index];
        
    } 

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
        if(n==0 || n==1){
          //  String op[]={""};
            String[] op=new String[1];
            op[0]="";
            return op;
        }
        
        String[] so=keypad(n/10);
        String str=getstring(n%10);
        String[] output=new String[so.length *str.length()];
        int k=0;
        for(int i=0;i<so.length;i++){
            for(int j=0;j<str.length();j++){
                output[k++]=so[i]+str.charAt(j);
            }
        }
        return output;

	}
