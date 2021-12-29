public class Solution {
    // Time complexity for one operation in heap is logN.
    

	public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
        	
   
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        // Method 1
        // TCO(NlogN), SC:O(N)
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }
        for(int i=k;i<input.length;i++){
            if(pq.peek()<input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
        //Method 2
       // TC:O(Nlogk), SC: O(k)
        for(int value:input){
            pq.add(value);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        
        return pq.poll();
		

	}
}
