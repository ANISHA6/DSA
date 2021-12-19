public class solution {

	// Return a 2D array that contains all the subsets which sum to k
    
    public static int[][] helper(int[] input, int si, int k){
     if(si>input.length-1){
            if(k==0){
                return new int[1][0];
            }else
                return new int[0][0];
        }
        
          int[][] sol1= helper(input,si+1,k-input[si]);
          int[][] sol2=helper(input,si+1,k);
        int r=sol1.length+sol2.length;
        int[][] output=new int[r][]; // Here only defining size of row
        int p=0;
        for(int i=0;i<sol1.length;i++){
            output[p]=new int[sol1[i].length+1]; // Declaring size of col, same as declaring 1D array
            output[p][0]=input[si]; //Addind element in sol1
            
            for(int j=1;j<=sol1[i].length;j++){
                output[p][j]=sol1[i][j-1];
            }
            p++;
        }
	    
	    //1st way to copying elements from sol2 to output
	    
// 	    for(int i=0;i<sol2.length;i++){
//             output[p++]=sol2[i];
//         }
	    
	    // 2nd way to copying elements from sol2 to output
        for(int i=0;i<sol2.length;i++){
            output[p]=new int[sol2[i].length];// Also called jagged array in java
           
            
            for(int j=0;j<sol2[i].length;j++){ //Coping sol2 to main output withut including current element
                output[p][j]=sol2[i][j];
            }
            p++;
        }
        return output;
        
        
    }
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
        
        return helper(input,0,k);
        

	}
}
