public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int[][] mat=new int[M][N];
    
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                mat[i][j]=sc.nextInt();
            }
        }
              boolean[] row=new boolean[M];
              boolean[] col=new boolean[N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                
                if(mat[i][j]==1){
                    row[i]=true;
                    col[j]=true;
                }
                
            }
        }
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                
                if(row[i] || col[j]){
                    mat[i][j]=1;
                    
                }
            }
        }
        
              
       for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
               System.out.print(mat[i][j] +" ");
            }
            
             System.out.println();
        }   
	}

}
