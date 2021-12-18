public class Solution{

	public static void rotate(int input[][]){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
	 	 * Taking input and printing output is handled automatically.
         
		*/
       int n=input.length;
        // Transpose the matrix
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=input[j][i];
                input[j][i]=input[i][j];
                input[i][j]=temp;
            }
        }
        //Reverse the matrix first row to last row
        for(int j=0;j<n;j++){ // for col
            for(int i=0, k=n-1;i<k;i++, k--){ //i for first row and k for last row
                int temp=input[i][j];
                input[i][j]=input[k][j];
                input[k][j]=temp;
            }
        }
	}
}
