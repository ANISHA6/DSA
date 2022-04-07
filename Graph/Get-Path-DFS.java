        
 public static ArrayList<Integer> getpath(int[][] matrix, int v1, int v2, boolean[] visited){
     
     if(v1==v2){
         ArrayList<Integer> ans=new ArrayList<>();
         ans.add(v2);
         return ans;
     }
     
     visited[v1]=true;
     
     for(int i=0;i<matrix.length;i++){
         if(matrix[v1][i]==1 && !visited[i]){
             ArrayList<Integer> smallAns=getpath(matrix, i, v2, visited);
             
             if(smallAns!=null){
                 smallAns.add(v1);
                 return smallAns;
             }
         }
     }
     return null;
 }
    
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
                      
 Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] matrix=new int[v][v];
        
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            matrix[v1][v2]=1;
            matrix[v2][v1]=1;  
        }
        int s=sc.nextInt();
        int d=sc.nextInt();
        
       
        
        boolean[] visited=new boolean[v];
        ArrayList<Integer> ans=getpath(matrix,s,d, visited);
        
        
        
        
        if(ans!=null){
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
    }
