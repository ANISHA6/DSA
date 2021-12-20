// Method 1

public class solution {
   static int j=0;
    	public static void helper(String input,String[] op,String smallop){
            if(input.length()==0){
                op[j++]=smallop;
                return;
            }
     for(int i=0;i<input.length();i++){
            
             char ch=input.charAt(i);
             String ip=input.substring(0,i)+input.substring(i+1);// Removing ith character from input
              helper(ip,op,smallop+ch);
         }}
	
	public static String[] permutationOfString(String input){
		// Write your code here
        
        int s=1;
        for(int i=1;i<=input.length();i++){//Calculating total no. of permutation of given string 
            s*=i;
        }
        String[] op=new String[s];
        helper(input,op,"");
        return op;
        
  }
}

//Method 2

public static String[] permutationOfString(String input){
		// Write your code here
        
       
        if(input.length()==0){
            String[] output={""};
            return output;
        }
        String[] smallOutput=permutationOfString(input.substring(1));
        String[] op=new String[input.length()*smallOutput.length];
        
        int k=0;
        for(int i=0;i<smallOutput.length;i++){
            String currentStr=smallOutput[i];
            for(int j=0;j<=currentStr.length();j++){
                op[k++]=currentStr.substring(0,j)+input.charAt(0)+currentStr.substring(j);
            }
        }
        return op;
        
