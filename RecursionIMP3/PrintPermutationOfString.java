public class solution {
    public static void helper(String input, String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        
        
     
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            String ros=input.substring(0,i)+input.substring(i+1);// Rest of string 
           
                helper(ros,output+ch);
           
            
        }
         }

	public static void permutations(String input){
		// Write your code here
        helper(input, "");

	}
}
