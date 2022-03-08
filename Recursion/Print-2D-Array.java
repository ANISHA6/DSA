public class solution {
    
    public static void print(int input[][],int n,int m,int row){
        
        if(n==0){
            return;
        }
        int x=n;
        while(x!=0){
            for(int i=0;i<m;i++){
                System.out.print(input[row][i] +" ");
            }
            System.out.println();
            x--;
        }
        print(input,n-1,m,row+1);
        
    }
	public static void print2DArray(int input[][]) {
		// Write your code here
        int n=input.length;
        int m=input[0].length;
        
    print(input,n,m,0);
	}
}
