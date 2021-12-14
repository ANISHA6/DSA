import java.util.*;
public class Solution {

	public static void wavePrint(int mat[][]){
		//Your code goes here
        int row=mat.length;
        if(row==0){
            return ;
        }
       int mCol=mat[0].length;
        for(int j=0;j<mCol;j++){
            if(j%2==0){
                for(int i=0;i<row;i++){
                    System.out.print(mat[i][j] +" ");
                }
            }
            else{
                for(int k=row-1;k>=0;k--){
                    System.out.print(mat[k][j]+ " ");
                }
            }
        }
        
   
      
	}

}
