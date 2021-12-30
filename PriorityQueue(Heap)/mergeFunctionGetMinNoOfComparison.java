public class Main {
// To get minimum no. of comparison we will take two  given sorted arrays with 
//minimum size, so for it we will use min priority queue
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int[] size=new int[M];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<M;i++){
            size[i]=sc.nextInt();
            pq.add(size[i]);
        }
        int count=0;
        while(pq.size()>=2){
            int sum=pq.poll()+pq.poll();
            pq.add(sum);
            count+=sum-1;
        }
        
        System.out.println(count);

	}

}
