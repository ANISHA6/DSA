public class Solution {

	public static void spiralPrint(int matrix[][]){
        if(matrix.length==0){
            return;
        }
		
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
       
        int dir=0;
        int l=matrix.length;
        // if(l==0){
        //     return;
        // }
        while(top<=bottom && left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    System.out.print(matrix[top][i] +" ");
                    
                    
                }
                top++;
            }
                else if(dir==1){
                    for(int i=top;i<=bottom;i++){
                        System.out.print(matrix[i][right]+ " ");
                    }
                    right--;
                }
               else if(dir==2){
                    for(int i=right;i>=left;i--){
                        System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }
            else if(dir==3){
                for(int i=bottom;i>=top;i--){
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
                    
            }
            dir=(dir+1)%4;
        }
  }
}
       
        
