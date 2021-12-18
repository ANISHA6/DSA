public class Main {

	public static int helper(int cp, int childp, int j){
        if(cp==childp){
            return 0;
            
        }
        if(cp>childp || cp<-childp){
            return -1;
        }
        int f=helper(cp+j,childp,j+1);
        int b=helper(cp-j,childp,j+1);
        if(f!=-1 && b!=-1){
            return Math.min(f,b)+1;
        }
        if(f!=-1)
            return f+1;
        if(b!=-1)
            return b+1;
        return -1;
    }
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int X=sc.nextInt();
        System.out.println(helper(0,X,1));
        

	}

}

// In the jungle, Mother kangaroo is far away from his child kangaroo while some jungli animal came tries to hurt him. So, 
// mother kangaroo wants to reach to his son as fast as possible. Help her to reach his son
// Mother and child kangaroo are on 1D line (x-axis from -infinity to +infinity). 
//   Mother kangaroo is at origin(0) and child kangaroo is at some co-ordinate X. Mother kangaroo has special jump. 
//   In ith jump, she can take i steps forward or backward.
  
  
  
  
Help her to reach his son in minimum possible steps.
