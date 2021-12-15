public class Main {
    public static int pivot(int[] a,int s,int e){
        if(s==e){
            return s;
        }
        int n=a.length;
        int mid=(s+e)/2;
        int pre=(mid-1+n)%n;
        int next=(mid+1)%n;
        if(a[mid]>a[pre] && a[mid]>a[next]){
            return mid;
        }
        else if(a[mid]<a[pre]){
            return pivot(a,s,pre);
        }
        else{
            return pivot(a,next,e);
        }
    }

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            
        }
        int x=sc.nextInt();
        int pivoti=pivot(a,0,n-1);
        int s=(pivoti+1)%n;
        int e=pivoti;
        
        int count=0;
        
        while(count<n){
            if(a[s]+a[e]==x){
                System.out.println("true");
                return;
            }
            else if(a[s]+a[e]<x){
                s=(s+1)%n;
                count++;
            }
            else{
                e=(e-1+n)%n;
                count++;
            }
        }
        if(count>=n){
            System.out.println("false");
        }

	}

}
