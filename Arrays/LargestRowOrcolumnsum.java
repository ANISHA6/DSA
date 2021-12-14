import java.util.*;
public class Solution {

	public static void findLargest(int mat[][]){
		//Your code goes here
        if(mat.length==0){
            System.out.print("row 0 -2147483648");
            return;
        }
      
        int rmax=Integer.MIN_VALUE;
        int rindex=0;

        for(int i=0;i<mat.length;i++){
           int sumr=0;
            for(int j=0;j<mat[i].length;j++){
                sumr+=mat[i][j];
                
            }
            if(sumr>rmax){
                rmax=sumr;
                rindex=i;
            }
        }
        int cmax=Integer.MIN_VALUE;
        int cindex=0;
       
        for(int j=0;j<mat[0].length;j++){
           int sumc=0;
            for(int i=0;i<mat.length;i++){
                sumc+=mat[i][j];
            }
            if(sumc>cmax){
                cmax=sumc;
                cindex=j;
            }
           
        }
        
        if(rmax>=cmax){
            System.out.print("row" + " " +rindex + " "  +rmax);
            
        }
        else
            System.out.print("column" +" "+ cindex +  " " + cmax);
        
      
	}

}
