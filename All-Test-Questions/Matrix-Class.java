/* Signature of four required functions is given in the code. You can create other functions as well if you need.
*  Also you should submit your code even if you are not done with all the functions. 
*/

public class mat{
	int [][] matrix;
	
	mat(int [][] mat)
	{
		matrix=mat;
	}
    mat(){
        
    }
		
	
	    public static mat add(mat a,mat b)
	    {
            
            int[][] ans=new int[a.matrix.length][a.matrix[0].length];
         
            for(int i=0;i<a.matrix.length;i++){
                for(int j=0;j<a.matrix[0].length;j++){
                    ans[i][j]=a.matrix[i][j]+b.matrix[i][j];
                }
            }
        mat obj=new mat(ans);
            return obj;
            
	      
	    }
	    public static mat multiply(mat a,mat b)
            
	    {
            int r=a.matrix.length;
            int c=b.matrix[0].length;
            int[][] ans=new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                   
                    for(int k=0;k<a.matrix[0].length;k++){
                        
                        ans[i][j]+=a.matrix[i][k]*b.matrix[k][j];
                        
                    }
                }
            }
            mat mul=new mat(ans);
            return mul;
            
	       
	    }
	    public static mat transpose(mat m)
	    {         
            int c=m.matrix[0].length;
            int[][] ans=new int[c][c];
            
            for(int i=0;i<m.matrix.length;i++){
                for(int j=0;j<m.matrix[0].length;j++){
                    
                   ans[i][j]=m.matrix[j][i];
                }}
         mat trans=new mat(ans);
            return trans;
	    	
	    }
	    public static mat rotate(mat m)
	    {
                       int r=m.matrix.length;
            int c=m.matrix[0].length;
            
            int[][] ans=new int[c][r];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    ans[c-j-1][i]=m.matrix[i][j];
                }
            }
	    	mat obj=new mat(ans);
            return obj;
	    }
	    public  void print()
	    {
	        for(int i=0;i<this.matrix.length;i++)
	        {
	            for(int j=0;j<this.matrix[0].length;j++)
	            {
	                System.out.print(this.matrix[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
	 }
