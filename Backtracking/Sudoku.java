public class Solution {
    
    public static boolean isValid(int[][] matrix, int row, int col, int c){
        for(int k=0;k<9;k++){
            if(matrix[row][k]!=0 && matrix[row][k]==c )// checking for row
                return false;
            if(matrix[k][col]!=0 && matrix[k][col]==c) // for column
                return false;
            if(matrix[3*(row/3)+k/3][3*(col/3)+k%3]!=0 && matrix[3*(row/3)+k/3][3*(col/3)+k%3]==c) // for board(3*3)
                return false;
        }
        return true;
    }

	public static boolean isItSudoku(int matrix[][]) {

		// Write your code here.
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==0){
                    for(int c=1;c<=9;c++){
                        if(isValid(matrix, i, j, c)){
                        matrix[i][j]=c;
                        if(isItSudoku(matrix)){
                            return true;
                        }
                        else
                            matrix[i][j]=0;
                         }
                }
                    return false;
                    
                }
            }
        }
        return true;
	}
}
