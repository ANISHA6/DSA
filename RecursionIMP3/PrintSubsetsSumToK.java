 public static void printHelper(int[] input, int[] output, int si, int k){
        if(si==input.length){
            if(k==0){
                for(int value:output){
                    System.out.print(value+" ");
                }
                System.out.println();
                return;
            }else{
                return;
            }
        }
        int[] newOutput=new int[output.length+1];
        int i=0;
        for(;i<output.length;i++){
            newOutput[i]=output[i];
        }
        newOutput[i]=input[si];
        printHelper(input,newOutput,si+1,k-input[si]);
        printHelper(input, output, si+1, k);
    }
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
	   //Method 1
      int[] output=new int[0];
        printHelper(input, output, 0, k);
    // print(input,0,k,"",0);
  }

//Method 2
 public static void print(int[] input,int si, int k,String o,int ss){
       if(si==input.length){
            if(ss==k){
               
                System.out.println(o);
                  }
            return;
        }
        
        print(input,si+1,k,o+input[si]+" ",ss+input[si]);
        print(input,si+1,k,o,ss);
        
        
    }
