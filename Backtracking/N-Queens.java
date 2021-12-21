public class Solution {
	    public static boolean isSafe(int[][] board, int row, int col){
            
        // for checking vertically
            for(int r=row-1,c=col;r>=0;r--){
                if(board[r][c]==1){
                    return false;
                }
            }
            // check left diagonal
            for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--){
                if(board[i][j]==1){
                    return false;
                }
            }
            // check right diagonal
            for(int i=row-1, c=col+1;i>=0 && c<board.length;i--,c++){
                if(board[i][c]==1)
                    return false;
            }
            return true;
            
            
            
        }
    public static void helper(int[][] board, int n, int i){
         if(i==n){
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    System.out.print(board[r][c]+" ");
                    
                }
            }
            System.out.println();
            return;
            
        }
        for(int j=0;j<n;j++){
            if(isSafe(board,i,j)){
                board[i][j]=1;
                helper(board,n,i+1);
                board[i][j]=0;
            }
           
        }
         }
		
public static void placeNQueens(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */
    int[][] board=new int[n][n];
      helper(board,n,0);

	}
	
}
