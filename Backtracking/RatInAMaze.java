
public class Solution {
    public static boolean solveMaze(int maze[][], int i,int j, int[][] paths){
        int n=maze.length;
        if(i<0 ||i>=n || j<0 ||j>=n ||maze[i][j]==0 || paths[i][j]==1){//if Maze is blocked and path is already included
            return false;
        }
        paths[i][j]=1; //Imclude cell in current path
        if(i==n-1 && j==n-1){
            //paths[i][j]=0;
            return true;
        }
        //Explore further in all directions
        // top
        if(solveMaze(maze, i-1,j,paths)){
            return true;
        }
        //right
        if(solveMaze(maze, i,j+1,paths)){
            return true;
        }
        //down
            if(solveMaze(maze, i+1,j,paths)){
            return true;
        }
        //left
        if(solveMaze(maze, i,j-1,paths)){
            return true;
        }
        return false;
        
    }

	public static boolean ratInAMaze(int maze[][]){

		
        
        
        int n=maze.length;
        int[][] paths=new int[n][n];
        return solveMaze(maze,0, 0, paths);  
  }
}
