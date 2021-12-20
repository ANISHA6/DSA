public class solution {
    public static void helper(int[] input, int si, int[] output){
        if(si==input.length){
            for(int i:output){
                System.out.print(i+" ");
            }
            System.out.println();
            return ;
        }
        int[] newo=new int[output.length+1];
        int i=0;
        for(;i<output.length;i++){
            newo[i]=output[i];
        }
        newo[i]=input[si];
        helper(input,si+1,output);
        helper(input,si+1, newo);
    }
    
	public static void printSubsets(int input[]) {
		// Write your code here
        int[] output=new int[0];
        helper(input,0,output);

	}
}
