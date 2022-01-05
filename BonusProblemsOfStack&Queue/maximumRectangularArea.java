public class Solution {
    
    
    public static int maxarea(int[] mat, int c){
        //Same as maximum area in histogram
        Stack<Integer> st=new Stack<Integer>();
        int i=0;
        int maxa=0;
        while(i<c){
            if(st.isEmpty()|| mat[st.peek()]<=mat[i]){
                st.push(i);
                i++;
            }
            else{
                int top=st.pop();
                int a=mat[top]*(st.isEmpty()? i: i-st.peek()-1);
                maxa=Math.max(a,maxa);
            }
        }
        while(!st.isEmpty()){
            int top=st.pop();
                int a=mat[top]*(st.isEmpty()? i: i-st.peek()-1);
                maxa=Math.max(a,maxa);
        }
        return maxa;
    }
   public static int area(int r, int c, int[][] m){
       int ans=maxarea(m[0],c);//finding max area for first row
       for(int i=1;i<r;i++){//Findind max area for rest of rows
           for(int j=0;j<c;j++){
               if(m[i][j]!=0){
                   m[i][j]+=m[i-1][j];//Keeping ith row as a base and adding with its previous row
               }
           }
           ans=Math.max(ans, maxarea(m[i],c));//Finding max area for every rows
       }
       return ans;
   }

	public static void main(String[] args) {
		/* 
			* Your class should be named Solution.
			* Read input as specified in the question.
			* Print output as specified in the question.
			* Write your code here
		 */
        Scanner sc=new Scanner(System.in);
     int N=sc.nextInt();
        int M=sc.nextInt();
        
        int matrix[][]=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        if(N!=0){
            System.out.println(area(N, M, matrix));
        }
       else{
           System.out.println(0);
       }

}
}
