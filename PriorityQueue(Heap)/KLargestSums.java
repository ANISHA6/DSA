public class Main {


	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
       Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int m=sc.nextInt();
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=1;i<N;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int sum=(i==0)?arr[j]:(arr[j]-arr[i-1]);
                if(pq.size()<k){
                    pq.add(sum);
                }else{
                    if(pq.peek()<sum){
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }
        int mul=1;
        while(!pq.isEmpty()){
            mul*=pq.poll();
        }
        if(mul>m){
            System.out.println("True");
        }else
            System.out.println("False");
	}

}
