public class Main {
    
    public static void swap(int[] a,int s,int e){
        int t=a[s];
        a[s]=a[e];
        a[e]=t;
    }
    
    public static int minswap(int[] a, int[] b){
        int n=a.length;
        if(n==1 || n==0){
            return 0;
        }
        int count=0;
        
        for(int i=0;i<n;i++){
            if(a[i]!=b[i]){
                int j=i;
                while(b[j]!=a[i]){
                    j++;
                    if(j>n){
                        return 0;
                    }
                    
                } // if equal then swap in arr2
                swap(b,i,j);
                count++;
            }
        }
        return count;
    }

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
    
        int[] f=new int[n];
     
        for(int i=0;i<n;i++){
            f[i]=sc.nextInt();
        }
        
    int[] s=new int[n];
        for(int i=0;i<n;i++){
            s[i]=sc.nextInt();
        }
        int ans=minswap(f,s);
        System.out.println(ans);

	}

}
