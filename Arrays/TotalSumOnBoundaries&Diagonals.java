public class Solution {
    public static int getFirstDigsum(int[][] mat, int n){
        int currrow=0;
        int currcol=0;
        int sum=0;
        while(currrow<n && currcol<n){
            sum+=mat[currrow][currcol];
            currrow++;
            currcol++;
        }
        return sum;
    }
    
    
    public static int getSecDigsum(int[][] mat, int n){
        int currrow=0;
        int currcol=n-1;
        int sum=0;
        while(currrow<n && currcol>=0){
            sum+=mat[currrow][currcol];
            currrow++;
            currcol--;
        }
        return sum;
    }
    
    
    public static int getBoundarysum(int[][] mat, int n){
        int sum=0;
        for(int i=1;i<n-1;i++){
            sum+=mat[0][i];//upper side
            sum+=mat[n-1][i]; //Lower side
            sum+=mat[i][0]; //Left side
            sum+=mat[i][n-1]; // Right side
        }
        return sum;
    }

	public static void totalSum(int[][] mat) {
		//Your code goes here
        
        int n=mat.length;
        if(n==0){
            System.out.println();
        }
        int totalsum=getFirstDigsum(mat,n)+getSecDigsum(mat,n)+getBoundarysum(mat,n);
        if(n%2!=0){
            totalsum-=mat[n/2][n/2];
        }
        System.out.println(totalsum);
	}
}
        
