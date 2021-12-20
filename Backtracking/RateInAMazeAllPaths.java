public class Solution {

    	static void printAllPaths(int maze[][], int i, int j, int[][] paths){
            int n=paths.length;
            if(i<0 ||i>=n ||j<0 ||j>=n ||maze[i][j]==0 ||paths[i][j]==1){
                return;
            }
            paths[i][j]=1;
            if(i==n-1 && j==n-1){
                for(int r=0;r<n; r++){
                    for(int c=0;c<n;c++){
                        System.out.print(paths[r][c]+" ");
                    }
                 
                }
                System.out.println();
                paths[i][j]=0;
                return;
            }
         printAllPaths(maze,i-1,j,paths);
         printAllPaths(maze,i+1,j,paths);
         printAllPaths(maze,i,j-1,paths);
            printAllPaths(maze,i,j+1,paths);
            paths[i][j]=0;
           }

	static void ratInAMaze(int maze[][], int n) {
		/* 
			* Your class should be named Solution.
			* Write your code here
		 */
        int[][] paths=new int[n][n];
         printAllPaths(maze,0,0,paths);

	}

}
