public class Solution {

	
	public static void main(String[] args) {
		/* Your class should be named Solution.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Z=sc.nextInt();
        int[] arr=new int[N];
        
         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
             pq.add(arr[i]);
        }
        int count=0;
     
    
        while(Z>0 && !pq.isEmpty()){
               Z-=pq.peek();
               int temp=pq.poll();
                if(temp/2>0){
                   pq.add(temp/2);
            }
                count++;
        }
            
            if(Z<=0){
                System.out.println(count);
        
            }else{
                System.out.println("Evacuate");
               
            }
            
      }

}
