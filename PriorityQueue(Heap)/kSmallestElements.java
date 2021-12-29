
public class Solution {

	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        
        // Using minimum priority queue
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            pq.add(input[i]);
        }
        for(int i=0;i<k;i++){
            
                ans.add(pq.poll());
            }
        
        return ans;
        
        // Using maximum priority queue
     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
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
