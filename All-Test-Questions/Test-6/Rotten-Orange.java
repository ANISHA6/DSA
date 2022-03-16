import java.util.Scanner;
import java.util.*;
 class Index{
        int x;
        int y;
        public Index(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

public class Main {
    //Method 1 using pair class
  //TC:O(N*M)
  //SC:O(N*M)

    public static int orangeRotting(int[][] grid){
        Queue<Index> qu=new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    qu.add(new Index(i, j));//Putting the index of rotten orange in queue
                }
                if(grid[i][j]==1){
                    freshCount+=1; //counting all the fresh orange
                }
            }
            
        }
        int r=grid.length;
        int c=grid[0].length;
        int[][] direction={{1,0}, {0,1},{-1, 0}, {0,-1}};
        int count=0;// for counting the time
        while(!qu.isEmpty() && freshCount>0){
            count++;
            int size=qu.size();
            while(size-->0){
                Index temp=qu.poll();
                for(int[] d:direction){
                    int row=temp.x+d[0];
                    int col=temp.y+d[1];
                    
                    if(row<0 || col<0 || row>=r || col>=c || grid[row][col]==0 || grid[row][col]==2){
                        continue;
                    }
                    qu.add(new Index(row, col));
                    grid[row][col]=2;
                    freshCount--;
                }
            }
            
            
        }
        return freshCount==0?count:-1;
        
        
    }
    
    //Method 2
    
    public static boolean isValid(int r, int c, int rmax, int cmax){
        if(r<0||r>=rmax|| c<0|| c>=cmax){
            return false;
        }
        return true;
    }
    public static int rotten(int[][] v, int rmax, int cmax){
        
        boolean changed=false;
        int no=2;
        while(true){
            for(int i=0;i<rmax;i++){
                for(int j=0;j<cmax;j++){
                    if(v[i][j]==no){
                        if(isValid(i+1,j,rmax, cmax) &&v[i+1][j]==1){
                            v[i+1][j]=v[i][j]+1;
                            changed=true;
                            
                        }
                         if(isValid(i,j+1,rmax, cmax) &&v[i][j+1]==1){
                            v[i][j+1]=v[i][j]+1;
                            changed=true;
                            
                        }
                         if(isValid(i-1,j,rmax, cmax) &&v[i-1][j]==1){
                            v[i-1][j]=v[i][j]+1;
                            changed=true;
                            
                        }
                         if(isValid(i,j-1,rmax, cmax) &&v[i][j-1]==1){
                            v[i][j-1]=v[i][j]+1;
                            changed=true;
                            
                        }
                        
                        
                    }
                }
            }
            
            if(!changed){
                break;
            }
            changed=false;
            no++;
        }
        
        for(int i=0;i<rmax;i++){
            for(int j=0;j<cmax;j++){
                if(v[i][j]==1){
                    return -1;
                }
            }
        
        }
        return no-2;
        
    }

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int arr[][]=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int ans=orangeRotting(arr);//Calling method 1 function
        int ans=rotten(arr, N, M);// Calling method 2 function
        System.out.println(ans);

	}

}
