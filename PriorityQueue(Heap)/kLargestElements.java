public class Solution {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
    ArrayList<Integer> ans=new ArrayList<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        
        //Method 1
        
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }
        for(int i=k;i<input.length;i++){
            if(pq.peek()<input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
        
        
        
        //Method 2
        
        for(int value:input){
            pq.add(value);
        if(pq.size()>k){
            pq.poll();
        }
    }
         while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
        
		
	}
}
